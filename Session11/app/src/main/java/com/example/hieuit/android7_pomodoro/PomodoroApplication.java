package com.example.hieuit.android7_pomodoro;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.service.PomorodoService;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;

import java.util.List;

/**
 * Created by Hieu It on 1/14/2017.
 */

public class PomodoroApplication extends Application {

    private static final String TAG = PomodoroApplication.class.toString();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        SharedPrefs.init(this);

        Intent intent = new Intent(this, PomorodoService.class);
        startService(intent);
        DbContext.instance.setRealmContext(this);
        for (Task task  : DbContext.instance.allTasks()) {
            Log.d(TAG,String.format("onCreate : %s",task));

        }
    }
}
