package com.ATM.service.impl;

import com.ATM.constants.DataType;
import com.ATM.entity.Client;
import com.ATM.service.BaseService;
import com.ATM.service.IFileService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileServiceImpl extends BaseService implements IFileService {

    private static final FileServiceImpl fileService = new FileServiceImpl();
    private final String PATH = System.getProperty("user.dir") + "/appdata/" ;

    public static FileServiceImpl getInstance() {
        return fileService;
    }

    @Override
    public void loadFromFile(DataType dataType) throws IOException {
        Scanner scanner = new Scanner(new File(PATH + dataType.getFileName()));
        if (dataType == DataType.CLIENT) {
            getClients().clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                storeToArray(line);
            }
        }
        if (dataType == DataType.BANKOMAT) {
            String value = Files.readAllLines(Paths.get(PATH + dataType.getFileName())).get(0);
            setBankomatBalance(Double.parseDouble(value));
        }
    }

    private void storeToArray(String line) {
        String[] clientData = line.split(" ");
        clients.add(new Client(
                Integer.parseInt(clientData[0]),
                parseToInt(clientData[1].split("-")),
                Integer.parseInt(clientData[2]),
                Double.parseDouble(clientData[3]),
                Long.parseLong(clientData[4])));
    }

    private int[] parseToInt(String[] strings) {
        int[] cardData = new int[4];
        for (int i = 0; i < strings.length; i++) {
            cardData[i] = Integer.parseInt(strings[i]);
        }
        return cardData;
    }

    @Override
    public void writeToFile(ArrayList<Client> clientArrayList) throws IOException {
        FileWriter fw = new FileWriter(PATH + DataType.CLIENT.getFileName(), false);
        for (Client client : clientArrayList) {
            fw.write(client.toFileString());
            fw.append('\n');
        }
        fw.close();
    }

    @Override
    public void writeToFile(double bankomatBalance) throws IOException {
        Files.write(Paths.get(PATH + DataType.BANKOMAT.getFileName()), Double.toString(bankomatBalance).getBytes());
    }
}
