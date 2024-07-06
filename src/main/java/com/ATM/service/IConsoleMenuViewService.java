package com.ATM.service;

import com.ATM.constants.MenuItems;

import java.util.Map;

public interface IConsoleMenuViewService {
    Map<Integer, MenuItems> showMenu();
}
