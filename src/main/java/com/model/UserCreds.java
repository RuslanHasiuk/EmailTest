package com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserCreds {
    @SerializedName(value = "user_credentials")
    private List<Credentials> userCredentials;

    public UserCreds() {
    }

    public List<Credentials> getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(List<Credentials> userCredentials) {
        this.userCredentials = userCredentials;
    }
}
