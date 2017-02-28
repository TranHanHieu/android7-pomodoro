package com.example.hieuit.android7_pomodoro.settings;

/**
 * Created by Hieu It on 1/14/2017.
 */

public class LoginCredentials{
    private String username;
    private String password;
    private String accessToken;

    public LoginCredentials(String username, String password, String accessToken) {
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
