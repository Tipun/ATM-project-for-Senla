package com.ATM.service.java.com.ATM.service.impl;

import com.ATM.service.java.com.ATM.exceptions.InputErrorException;
import com.ATM.service.java.com.ATM.exceptions.NotEnoughMoneyInBankomatException;
import com.ATM.service.java.com.ATM.exceptions.NotSufficientBalanceException;
import com.ATM.service.java.com.ATM.service.BaseService;

import java.io.IOException;

public class WithdrawServiceImpl extends BaseService {
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();
    private static final CheckBalanceServiceImpl checkBalanceService = CheckBalanceServiceImpl.getInstance();

    @Override
    public void execute() throws IOException, NotSufficientBalanceException, NotEnoughMoneyInBankomatException, InputErrorException {

        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                checkBalanceService.execute();
                double withdrawAmount = getDoubleFromConsole("Пожалуйста, введите желаемую сумму для снятия средств с карты");
                checkCurrentBalance(withdrawAmount);
                checkMoneyInBankomat(withdrawAmount);
                double balanceAfterWithdraw = Math.round((getClients().get(i).getBalance() - withdrawAmount) * 100.0) / 100.0;
                System.out.println("Баланс после снятия -> " + balanceAfterWithdraw);
                getClients().get(i).setBalance(balanceAfterWithdraw);
                setBankomatBalance(getBankomatBalance() - withdrawAmount);
            }
        }
        fileService.writeToFile(getBankomatBalance());
        fileService.writeToFile(getClients());
    }

    private void checkMoneyInBankomat(double withdrawAmount) throws NotEnoughMoneyInBankomatException {
        if (withdrawAmount > getBankomatBalance()) {
            throw new NotEnoughMoneyInBankomatException("Не достаточно средств в банкомате для снятия данной суммы");
        }
    }

    private void checkCurrentBalance(double withdrawAmount) throws NotSufficientBalanceException {
        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                if (getClients().get(i).getBalance() - withdrawAmount < 0) {
                    throw new NotSufficientBalanceException("Не достаточно средств на балансе карты для снятия");
                }
            }
        }
    }
}
