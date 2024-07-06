package com.ATM.service.impl;

import com.ATM.exceptions.*;
import com.ATM.service.BaseService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;

public class LoginServiceImpl extends BaseService {
    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
    private static final AccountBlockServiceImpl accountBlockService = AccountBlockServiceImpl.getInstance();
    private static final String CARD_PATTERN = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";

    @Override
    public void execute() throws InputErrorException, NoSuchClientException, NoSuchCardException, AccountBlockException, IOException {
        String cardNumber = getStringFromConsole("Пожалуйста, введите номер карты в формате xxxx-xxxx-xxxx-xxxx", CARD_PATTERN);
        System.out.println("Номер карты -> " + cardNumber);
        if (checkForCardExisting(cardNumber)) {
            accountBlockService.checkCardForBlockEnding(cardNumber);
        } else {
            throw new NoSuchCardException();
        }
        int attempts = 3;
        while (attempts != 0) {
            int pinCode = getIntFromConsole("Пожалуйста введите PIN код карты в формате xxxx");
            System.out.println("PIN code -> " + pinCode);
            if (checkPinCode(cardNumber, pinCode)) {
                setLoggedClientId(getClientId(cardNumber));
                break;
            }
            attempts--;
            LOGGER.error("Wrong PIN code. Attempts remained: " + attempts);
        }
        checkForPinInputAttempts(attempts, cardNumber);
    }

    private void checkForPinInputAttempts(int attempts, String cardNumber) throws NoSuchClientException, IOException {
        if (attempts == 0) {
            accountBlockService.blockAccount(cardNumber);
        }
    }

    private boolean checkPinCode(String cardNumber, int pinCode) {
        for (int i = 0; i < getClients().size(); i++) {
            if (checkForCardExisting(cardNumber) && pinCode == getClients().get(i).getPinCode()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForCardExisting(String cardNumber) {
        int[] card = {
                Integer.parseInt(cardNumber.split("-")[0]),
                Integer.parseInt(cardNumber.split("-")[1]),
                Integer.parseInt(cardNumber.split("-")[2]),
                Integer.parseInt(cardNumber.split("-")[3])};

        for (int i = 0; i < getClients().size(); i++) {
            if (Arrays.equals(getClients().get(i).getCardNumber(), card)) {
                return true;
            }
        }
        return false;
    }

    private int getClientId(String cardNumber) throws NoSuchClientException {
        int[] card = {
                Integer.parseInt(cardNumber.split("-")[0]),
                Integer.parseInt(cardNumber.split("-")[1]),
                Integer.parseInt(cardNumber.split("-")[2]),
                Integer.parseInt(cardNumber.split("-")[3])};
        for (int i = 0; i < getClients().size(); i++) {
            if (Arrays.equals(getClients().get(i).getCardNumber(), card)) {
                return getClients().get(i).getClientId();
            }
        }
        throw new NoSuchClientException();
    }
}
