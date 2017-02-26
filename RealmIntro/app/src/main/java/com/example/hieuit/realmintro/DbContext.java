package com.example.hieuit.realmintro;

import android.content.Context;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Hieu It on 2/25/2017.
 */

public class DbContext {
    private Realm realm;

    public DbContext(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void update(Person person,String name,int age){
        realm.beginTransaction();
        person.setName(name);
        person.setAge(age);
        realm.commitTransaction();
    }

    public void addOrUpdate(Person person){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(person);
        realm.commitTransaction();

    }

    public Person addRealm(Person person){
        realm.beginTransaction();
        Person addPerson = realm.copyToRealm(person);
        realm.commitTransaction();
        return addPerson;
//        //1. Init realm
//        Realm.init(this);
//        Realm realm = Realm.getDefaultInstance();
//        //2. Create person
//        Person p = new Person("Hieu", 17);
//        //3. add person into realm
//        //thread-safe (1 thời điểm chỉ mở cửa 1lan vao)
//        realm.beginTransaction();//mở
//        realm.copyToRealm(p); //copy từ bên ngoài vào
//        realm.commitTransaction();//đóng
    }

    public List<Person> allPersonList(){
        //lazy- list trả về 1 list chưa có gì, gọi đến list[1]...ms trả về
        return realm.where(Person.class).findAll();

    }

}
