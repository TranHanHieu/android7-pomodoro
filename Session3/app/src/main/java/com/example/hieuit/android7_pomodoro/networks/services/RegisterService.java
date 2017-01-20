package com.example.hieuit.android7_pomodoro.networks.services;

import com.example.hieuit.android7_pomodoro.networks.jsonmodels.RegisterBodyJson;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.RegisterResponseJson;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Hieu It on 1/20/2017.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterResponseJson> register(@Body RequestBody body);


}
