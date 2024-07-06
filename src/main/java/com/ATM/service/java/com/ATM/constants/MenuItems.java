package com.ATM.service.java.com.ATM.constants;

public enum MenuItems {
    CHECK_BALANCE("проверки баланса карты"),
    TOP_UP("пополнения баланса карты"),
    WITHDRAW("снятия средств с карты"),
    LOG_OUT("выхода"),
    LOGIN("авторизации");

    private final String description;

    MenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
