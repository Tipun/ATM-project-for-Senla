package com.ATM.service.java.com.ATM.service.impl;

import com.ATM.service.java.com.ATM.exceptions.InputErrorException;
import com.ATM.service.java.com.ATM.exceptions.MaximumTopUpLimitException;
import com.ATM.service.java.com.ATM.service.BaseService;

import java.io.IOException;

public class TopUpServiceImpl extends BaseService {
    private final CheckBalanceServiceImpl checkBalanceService = CheckBalanceServiceImpl.getInstance();
    private final FileServiceImpl fileService = FileServiceImpl.getInstance();

    @Override
    public void execute() throws IOException, MaximumTopUpLimitException, InputErrorException {
        checkBalanceService.execute();
        double topUpAmount = getDoubleFromConsole("Пожалуйста введите желаемую сумму для пополнения счета");
        checkTopUpLimit(topUpAmount);
        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                getClients().get(i).setBalance(Math.round((getClients().get(i).getBalance() + topUpAmount) * 100.0) / 100.0);
                System.out.println("Новый баланс: " + getClients().get(i).getBalance());
            }
        }
        setBankomatBalance(getBankomatBalance() + topUpAmount);
        fileService.writeToFile(getBankomatBalance());
        fileService.writeToFile(getClients());
    }

    private void checkTopUpLimit(double topUpAmount) throws MaximumTopUpLimitException {
        if (topUpAmount >= 1_000_000) {
            throw new MaximumTopUpLimitException();
        }
    }
}
