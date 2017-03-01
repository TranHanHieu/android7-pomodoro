package com.example.hieuit.android7_pomodoro.databases;

import android.content.Context;

import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.databases.models.TaskColor;
import com.example.hieuit.android7_pomodoro.networks.NetContext;
import com.example.hieuit.android7_pomodoro.networks.services.TaskService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class DbContext {

    private Realm realm;

    public static final DbContext instance = new DbContext();
    private List<Task > tasks;

    public void setRealmContext(Context context) {
        realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void deleteRealm(Task task){
        realm.beginTransaction();
        realm.delete(task.getClass());
        realm.commitTransaction();
    }

    public Task addOrUpdateRealm(Task task){
        realm.beginTransaction();
        Task addTask = realm.copyToRealmOrUpdate(task);
        realm.commitTransaction();
        return addTask;
    }

    public List<Task> getTaskList(){
        return realm.where(Task.class).findAll();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> allTasks(){
        //Fake data (dummy data)
        //1 create aray list
        if (tasks == null) {
            tasks = new ArrayList<>();
            //2. add some task and return
            tasks.add((new Task("Study recycelView", TaskColor.COLORS[0],2.3f)));
            tasks.add((new Task("Practice recycelView", TaskColor.COLORS[1],1.2f)));
            tasks.add((new Task("Practice netwroking", TaskColor.COLORS[2],0.5f)));
            tasks.add((new Task("Party End - Lectures", "#26C6DA",2.4f)));
            tasks.add((new Task("Study API", "#D4E157",1.4f)));
        }
        return tasks;
    }

    public void cleanAlls(){
        tasks.clear();
    }

    //    public List<TaskColor> allColors(){
//        //1 create aray list
//        ArrayList<TaskColor > colorTasks = new ArrayList<>();
//        //2. add some task and return
//        colorTasks.add((new TaskColor("#EF5350")));
//        colorTasks.add((new TaskColor("#8E24AA")));
//        colorTasks.add((new TaskColor("#3949AB")));
//        colorTasks.add((new TaskColor("#26C6DA")));
//        colorTasks.add((new TaskColor("#D4E157")));
//        colorTasks.add((new TaskColor("#2196F3")));
//        colorTasks.add((new TaskColor("#03A9F4")));
//        colorTasks.add((new TaskColor("#009688")));
//        return colorTasks;
//    }
    public void addTask(Task newTask){
        tasks.add(newTask);
    }

    public void edit(Task task) {
        //TO-DO
    }
}
