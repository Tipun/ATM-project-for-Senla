package com.ATM.service.java.com.ATM.service.factory;

import com.ATM.service.java.com.ATM.constants.MenuItems;
import com.ATM.service.java.com.ATM.exceptions.MissingMenuItemException;
import com.ATM.service.java.com.ATM.exceptions.ServiceMissingException;
import com.ATM.service.java.com.ATM.service.BaseService;
import com.ATM.service.java.com.ATM.service.impl.*;

import java.util.InputMismatchException;

public class ServiceFactoryImpl {
    private static final ServiceFactoryImpl serviceFactory = new ServiceFactoryImpl();

    public static ServiceFactoryImpl getInstance() {
        return serviceFactory;
    }

    public BaseService getService(MenuItems menuItems) throws ServiceMissingException, InputMismatchException, MissingMenuItemException {
        try {
            switch (menuItems) {
                case CHECK_BALANCE:
                    return new CheckBalanceServiceImpl();
                case TOP_UP:
                    return new TopUpServiceImpl();
                case WITHDRAW:
                    return new WithdrawServiceImpl();
                case LOGIN:
                    return new LoginServiceImpl();
                case LOG_OUT:
                    return new LogoutServiceImpl();
            }
        } catch (NullPointerException e) {
            throw new MissingMenuItemException("В меню нет такого пункта");
        }
        throw new ServiceMissingException("Illegal service type");
    }

}
