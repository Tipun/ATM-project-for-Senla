package com.ATM.service.impl;

import com.ATM.constants.MenuItems;
import com.ATM.exceptions.*;
import com.ATM.service.BaseService;
import com.ATM.service.IMenuRoutine;
import com.ATM.service.factory.ServiceFactoryImpl;

import java.io.IOException;
import java.util.Map;

public class MenuRoutineImpl extends BaseService implements IMenuRoutine {
    private static final MenuRoutineImpl menuRoutine = new MenuRoutineImpl();
    private static final ServiceFactoryImpl serviceFactory = ServiceFactoryImpl.getInstance();

    public static MenuRoutineImpl getInstance() {
        return menuRoutine;
    }

    public void menuCommandExecute(Map<Integer, MenuItems> itemsHashMap)
            throws InputErrorException, NoSuchClientException, IOException, NoSuchCardException,
            AccountBlockException, ServiceMissingException, NotSufficientBalanceException,
            MissingMenuItemException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException {
        serviceFactory.getService(itemsHashMap.get(getIntFromConsole("Выберите желаемое действие"))).execute();
    }
}
