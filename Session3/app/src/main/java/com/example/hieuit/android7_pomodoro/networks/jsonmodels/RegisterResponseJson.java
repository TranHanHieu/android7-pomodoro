package com.example.hieuit.android7_pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hieu It on 1/20/2017.
 */

public class RegisterResponseJson {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("token")
    private String token;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
