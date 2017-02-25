package com.example.hieuit.android7_pomodoro.networks.services;

import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.TaskJson;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Hieu It on 2/22/2017.
 */

public interface TaskService {
    @GET("task")
    Call<List<TaskJson>> getAllTask();
    @POST("task")
    Call<List<TaskJson>> addNewTask(@Body TaskJson taskJson);
    @PUT("task/{local_id}")
    Call<TaskJson> editATask(@Path("local_id")String local_id, @Body RequestBody body);
    @DELETE("task/{local_id}")
    Call<TaskJson> deleteTask(@Path("local_id")String local_id);
}
