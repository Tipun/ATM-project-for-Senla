package com.ATM.service.impl;

import com.ATM.service.BaseService;

public class LogoutServiceImpl extends BaseService {
    @Override
    public void execute() {
        setLoggedClientId(0);
    }
}
