package com.ATM.service;

import com.ATM.entity.Client;
import com.ATM.exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseService {
    protected static int loggedClientId;
    protected static ArrayList<Client> clients = new ArrayList<>();
    protected static double bankomatBalance;

    public static ArrayList<Client> getClients() {
        return clients;
    }

    protected static int getLoggedClientId() {
        return loggedClientId;
    }

    protected void setLoggedClientId(int loggedClientId) {
        BaseService.loggedClientId = loggedClientId;
    }

    public static double getBankomatBalance() {
        return bankomatBalance;
    }

    public static void setBankomatBalance(double bankomatBalance) {
        BaseService.bankomatBalance = bankomatBalance;
    }

    public void execute() throws InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException, NotSufficientBalanceException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException, MissingMenuItemException {
    }

    protected int getIntFromConsole(String message) throws InputErrorException {
        System.out.println(message);
        int input = 0;
        try {
            input = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            throw new InputErrorException("please enter an integer number");
        }
        return input;
    }

    protected String getStringFromConsole(String message, String pattern) throws InputErrorException {
        System.out.println(message);
        try {
            return new Scanner(System.in).next(pattern);
        } catch (InputMismatchException e) {
            throw new InputErrorException("wrong input");
        }
    }

    protected double getDoubleFromConsole(String message) throws InputErrorException {
        System.out.println(message);
        double input;
        try{
            input = new Scanner(System.in).nextDouble();
        }catch (InputMismatchException e){
            throw  new InputErrorException("please enter a double format number (for instance: 15,85) ");
        }
        return input;
    }
}
