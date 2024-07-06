package com.ATM.service.impl;

import com.ATM.exceptions.AccountBlockException;
import com.ATM.exceptions.NoSuchClientException;
import com.ATM.service.BaseService;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;

public class AccountBlockServiceImpl extends BaseService {
    private static final AccountBlockServiceImpl accountBlockService = new AccountBlockServiceImpl();
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();

    public static AccountBlockServiceImpl getInstance() {
        return accountBlockService;
    }

    public void blockAccount(String cardNumber) throws NoSuchClientException, IOException {
        System.out.println("Three attempts failed. The account with card number: " + cardNumber + " is going to block for 1 hour");
        getClients().get(getClientIndexFromList(cardNumber)).setLastBlockingTime(System.currentTimeMillis());
        fileService.writeToFile(getClients());
    }

    public void checkCardForBlockEnding(String cardNumber) throws NoSuchClientException, AccountBlockException {
        if ((getClients().get(getClientIndexFromList(cardNumber)).getLastBlockingTime() + 3.6e+6) > System.currentTimeMillis()) {
            System.out.println("Current time -> " + Instant.ofEpochMilli(System.currentTimeMillis())
                    .atZone(ZoneId.of("Europe/Paris")));
            throw new AccountBlockException("The card number: " + cardNumber + " is blocked fro 1 hour, unblocking time: " +
                    Instant.ofEpochMilli(getClients()
                                    .get(getClientIndexFromList(cardNumber))
                                    .getLastBlockingTime() + 3600000)
                            .atZone(ZoneId.of("Europe/Paris")));
        }
    }

    private int getClientIndexFromList(String cardNumber) throws NoSuchClientException {
        int[] card = {
                Integer.parseInt(cardNumber.split("-")[0]),
                Integer.parseInt(cardNumber.split("-")[1]),
                Integer.parseInt(cardNumber.split("-")[2]),
                Integer.parseInt(cardNumber.split("-")[3])};

        for (int i = 0; i < getClients().size(); i++) {
            if (Arrays.equals(getClients().get(i).getCardNumber(), card)) {
                return i;
            }
        }
        throw new NoSuchClientException("There is client with such card number");
    }
}
