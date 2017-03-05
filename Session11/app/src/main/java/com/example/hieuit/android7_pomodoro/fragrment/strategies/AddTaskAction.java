package com.example.hieuit.android7_pomodoro.fragrment.strategies;

import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;

/**
 * Created by Hieu It on 2/18/2017.
 */

public class AddTaskAction implements TaskAction {
    @Override
    public void excute(Task task) {
        DbContext.instance.addTask(task);
    }
}
