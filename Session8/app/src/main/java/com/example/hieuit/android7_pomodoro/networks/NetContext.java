package com.example.hieuit.android7_pomodoro.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hieu It on 1/18/2017.
 */

public class NetContext {
    private Retrofit retrofit;
    public static final NetContext instance = new NetContext();
    private NetContext(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://a-task.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
