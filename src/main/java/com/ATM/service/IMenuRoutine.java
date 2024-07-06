package com.ATM.service;

import com.ATM.constants.MenuItems;
import com.ATM.exceptions.*;

import java.io.IOException;
import java.util.Map;

public interface IMenuRoutine {
    void menuCommandExecute(Map<Integer, MenuItems> itemsHashMap) throws
            InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException,
            ServiceMissingException, NotSufficientBalanceException, MissingMenuItemException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException;
}
