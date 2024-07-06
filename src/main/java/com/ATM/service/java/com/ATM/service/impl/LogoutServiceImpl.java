package com.ATM.service.java.com.ATM.service.impl;

import com.ATM.service.java.com.ATM.service.BaseService;

public class LogoutServiceImpl extends BaseService {
    @Override
    public void execute() {
        setLoggedClientId(0);
    }
}
