package com.krzysztof.MailerAPI.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataProvider {

    private String email;
    private String password;
    private String[] data;

    public DataProvider() {
        this.data = getDataFromFile();
        this.email = data[0];
        this.password = data[1];
    }

    private String[] getDataFromFile() {
        String[] data = new String[2];
        try {
        FileReader fl = new FileReader("src/main/java/com/krzysztof/MailerAPI/service/data.txt");
        BufferedReader buf = new BufferedReader(fl);
        data[0] = buf.readLine();
        data[1] = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
