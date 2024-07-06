package com.ATM.service.java.com.ATM.service;

import com.ATM.service.java.com.ATM.constants.MenuItems;
import com.ATM.service.java.com.ATM.exceptions.*;

import java.io.IOException;
import java.util.Map;

public interface IMenuRoutine {
    void menuCommandExecute(Map<Integer, MenuItems> itemsHashMap) throws
            InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException,
            ServiceMissingException, NotSufficientBalanceException, MissingMenuItemException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException;
}
