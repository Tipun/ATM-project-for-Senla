package com.ATM;

import com.ATM.constants.DataType;
import com.ATM.constants.MenuItems;
import com.ATM.exceptions.*;
import com.ATM.service.impl.ConsoleMenuViewServiceImpl;
import com.ATM.service.impl.FileServiceImpl;
import com.ATM.service.impl.MenuRoutineImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class AppStarter {
    private static final Logger LOGGER = Logger.getLogger(AppStarter.class);
    private static final ConsoleMenuViewServiceImpl consoleMenuViewService = ConsoleMenuViewServiceImpl.getInstance();
    private static final MenuRoutineImpl menuRoutine = MenuRoutineImpl.getInstance();
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();

    public static void main(String[] args) {
        while (true) {
            try {
                fileService.loadFromFile(DataType.CLIENT);
                fileService.loadFromFile(DataType.BANKOMAT);
                Map<Integer, MenuItems> menuList = consoleMenuViewService.showMenu();
                menuRoutine.menuCommandExecute(menuList);
            } catch (IOException | InputErrorException | NoSuchClientException | NoSuchCardException
                     | AccountBlockException | ServiceMissingException | NotSufficientBalanceException
                     | MissingMenuItemException | MaximumTopUpLimitException | NotEnoughMoneyInBankomatException e) {
                LOGGER.error("an exception occurred -> " + e);
            }
        }



    }
}
