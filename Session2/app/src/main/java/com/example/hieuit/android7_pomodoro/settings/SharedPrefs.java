package com.example.hieuit.android7_pomodoro.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hieuit.android7_pomodoro.activitys.LoginActivity;
import com.example.hieuit.android7_pomodoro.activitys.SettingActivity;
import com.google.gson.Gson;

/**
 * Created by Hieu It on 1/14/2017.
 */

public class SharedPrefs {
    private static final String SHARED_PREFS_NAME = "SP";
    private static final String LOGIN_KEY = "Login";
    private static final String SETTING_KEY = "Setting";

    private static SharedPrefs instance;

    private SharedPreferences sharedPreferences;

    private Gson gson;

    public static SharedPrefs getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new SharedPrefs(context);
    }

    public SharedPrefs(Context context) {
        this.sharedPreferences = context.getSharedPreferences(
                SHARED_PREFS_NAME,
                Context.MODE_PRIVATE
        );
        gson = new Gson();
    }

    public void put(LoginCredentials loginCredentials) {
        //login....=>json String
        Gson gson = new Gson();
        String loginJSON = gson.toJson(loginCredentials);
        //out
        this.sharedPreferences.edit().putString(LOGIN_KEY, loginJSON).commit();

    }

    public void put(SettingCredentials s) {
        //setting....=>json String
        Gson gson = new Gson();
        String settingJSON = gson.toJson(s);
        //out
        this.sharedPreferences.edit().putString(SETTING_KEY, settingJSON).commit();

    }

    public LoginCredentials getLoginCredentials() {
        String loginJSON = this.sharedPreferences.getString(LOGIN_KEY, null);
        //string to object
        if (loginJSON == null) return null;
        return gson.fromJson(loginJSON, LoginCredentials.class);
    }

    public SettingCredentials getSettingCredentials() {
        String settingJSON = this.sharedPreferences.getString(SETTING_KEY, null);
        //string to object
        if (settingJSON == null) return null;
        return gson.fromJson(settingJSON, SettingCredentials.class);
    }
}
