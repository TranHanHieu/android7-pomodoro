package com.example.hieuit.android7_pomodoro.networks.services;

import com.example.hieuit.android7_pomodoro.databases.models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hieu It on 2/22/2017.
 */

public interface TaskService {
    @GET("task")
    Call<List<Task>>
}
