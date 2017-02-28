package com.example.hieuit.android7_pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hieu It on 2/22/2017.
 */

public class TaskJson {

    @SerializedName("local_id")
    public String localId;
    @SerializedName("payment_per_hour")
    public double paymentPerHour;
    @SerializedName("done")
    public boolean done;
    @SerializedName("id")
    public String id;
    @SerializedName("due_date")
    public String dueDate;
    @SerializedName("name")
    public String name;
    @SerializedName("color")
    public String color;

    public TaskJson(String localId, double paymentPerHour, boolean done, String id, String dueDate, String name, String color) {
        this.localId = localId;
        this.paymentPerHour = paymentPerHour;
        this.done = done;
        this.id = id;
        this.dueDate = dueDate;
        this.name = name;
        this.color = color;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public double getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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

    @Override
    public String toString() {
        return "TaskJson{" +
                "localId='" + localId + '\'' +
                ", paymentPerHour=" + paymentPerHour +
                ", done=" + done +
                ", id='" + id + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
