package com.utils;

import com.google.gson.Gson;
import com.model.UserCreds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomJsonParser {
    public static UserCreds parseUserCreds()  {
        String path = "src/main/resources/creds.json";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        UserCreds json = gson.fromJson(bufferedReader, UserCreds.class);
        return json;
    }
}
