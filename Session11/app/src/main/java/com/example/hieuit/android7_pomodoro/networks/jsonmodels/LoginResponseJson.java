package com.example.hieuit.android7_pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hieu It on 1/18/2017.
 */

public class LoginResponseJson {
    @SerializedName("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }
}
