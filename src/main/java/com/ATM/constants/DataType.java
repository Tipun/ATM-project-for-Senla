package com.ATM.constants;

public enum DataType {
    CLIENT("cardsdata.txt"), BANKOMAT("atmdata.txt");

    private final String fileName;

    DataType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
