package com.example.hieuit.android7_pomodoro.networks.services;

import android.app.DownloadManager;

import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginResponseJson;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Hieu It on 1/18/2017.
 */

public interface LoginService {
    @POST("login")
    Call<LoginResponseJson> login(@Body RequestBody body);

}
