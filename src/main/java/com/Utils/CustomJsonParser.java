package com.utils;

import com.google.gson.Gson;
import com.model.UserCreds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomJsonParser {
    public static UserCreds parseUserCreds() throws FileNotFoundException {
        String path = "C:\\Users\\travel\\IdeaProjects\\EmailTest\\src\\main\\resources\\creds.json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        UserCreds json = gson.fromJson(bufferedReader, UserCreds.class);
        return json;
    }
}
