package com.example.hieuit.realmintro;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hieu It on 2/25/2017.
 */

public class Person extends RealmObject {
    @PrimaryKey
    private String id;//khóa chính

    private String name;
    private int age;

    public Person() {//phải có contructor mặc định
        this(null,-1);
    }

    public Person(String name, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
