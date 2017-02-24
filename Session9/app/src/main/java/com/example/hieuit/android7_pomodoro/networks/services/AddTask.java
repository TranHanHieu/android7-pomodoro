package com.example.hieuit.android7_pomodoro.networks.services;

import com.example.hieuit.android7_pomodoro.databases.models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Hieu It on 2/20/2017.
 */

public interface AddTask {
    @POST("task")
    Call<Task> addTask(@Header("Content-Type") String contenType, @Header("Authorization") String token, @Body Task task);
}
