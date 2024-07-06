package com.ATM.entity;

import java.util.Arrays;

public class Client {
    private int clientId;
    private int[] cardNumber = new int[4];
    private int pinCode;
    private double balance;
    private Long lastBlockingTime;

    public Client(int clientId, int[] cardNumber, int pinCode, double balance, Long lastBlockingTime) {
        this.clientId = clientId;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.lastBlockingTime = lastBlockingTime;
    }

    public Long getLastBlockingTime() {
        return lastBlockingTime;
    }

    public void setLastBlockingTime(Long lastBlockingTime) {
        this.lastBlockingTime = lastBlockingTime;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int[] getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int[] cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (pinCode != client.pinCode) return false;
        if (Double.compare(client.balance, balance) != 0) return false;
        if (!Arrays.equals(cardNumber, client.cardNumber)) return false;
        return lastBlockingTime != null ? lastBlockingTime.equals(client.lastBlockingTime) : client.lastBlockingTime == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = clientId;
        result = 31 * result + Arrays.hashCode(cardNumber);
        result = 31 * result + pinCode;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (lastBlockingTime != null ? lastBlockingTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", cardNumber=" + cardNumber[0] + "-" + cardNumber[1] + "-" + cardNumber[2] + "-" + cardNumber[3] +
                ", pinCode=" + pinCode +
                ", balance=" + balance +
                ", lastBlockingTime=" + lastBlockingTime +
                '}';
    }

    public String toFileString() {
        return clientId +
                " " + cardNumber[0] + "-" + cardNumber[1] + "-" + cardNumber[2] + "-" + cardNumber[3] +
                " " + pinCode +
                " " + balance +
                " " + lastBlockingTime;
    }
}
