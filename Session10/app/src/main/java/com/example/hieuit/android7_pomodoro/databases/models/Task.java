package com.example.hieuit.android7_pomodoro.databases.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class Task extends RealmObject{
    @SerializedName("name")
    private String name;
    @SerializedName("color")
    private String color;
    @SerializedName("payment_per_hour")
    private float paymentPerHour;
    @SerializedName("done")
    private boolean isDone;
    @SerializedName("local_id")
    @PrimaryKey
    private String localId;

    public Task() {
        this(null,null,-1,false,null);
    }

    public Task(String name, String color, float paymentPerHour, boolean isDone, String localId) {
        this.name = name;
        this.color = color;
        this.paymentPerHour = paymentPerHour;
        this.isDone = isDone;
        this.localId =localId;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public Task(String name, String color, float paymentPerHour) {
        this.name = name;
        this.isDone = false;
        this.color = color;
        this.paymentPerHour = paymentPerHour;
        this.localId = UUID.randomUUID().toString();

    }

    public float getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(float paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void flipDone(){
        isDone = !isDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", paymentPerHour=" + paymentPerHour +
                ", isDone=" + isDone +
                '}';
    }
}
