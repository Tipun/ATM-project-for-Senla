package com.ATM.service.impl;

import com.ATM.service.BaseService;

public class CheckBalanceServiceImpl extends BaseService {
    private static final CheckBalanceServiceImpl checkBalanceService = new CheckBalanceServiceImpl();

    public static CheckBalanceServiceImpl getInstance() {
        return checkBalanceService;
    }

    @Override
    public void execute() {
        System.out.println("Баланс карты : " + getClients().stream()
                .filter(c -> c.getClientId() == getLoggedClientId())
                .findFirst()
                .get()
                .getBalance());
    }
}
