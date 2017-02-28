package com.example.hieuit.android7_pomodoro.networks.services;

import com.example.hieuit.android7_pomodoro.databases.models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Hieu It on 2/20/2017.
 */

public interface GetAllTask {
    @GET("task")
    Call<List<Task>> getAllTask(@Header("Authorization") String token);
}
