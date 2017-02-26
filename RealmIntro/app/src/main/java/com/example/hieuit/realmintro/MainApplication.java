package com.example.hieuit.realmintro;

import android.app.Application;
import android.util.Log;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Hieu It on 2/25/2017.
 */

public class MainApplication extends Application {
    private static final String TAG = MainApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();

        DbContext dbContext = new DbContext(this);
        Person p = new Person("hieu",21);
        Person addPerson = dbContext.addRealm(p);
        p.setName("abcd");
        dbContext.addOrUpdate(p);
        List<Person> personList = dbContext.allPersonList();
        for (Person person : personList) {
            Log.d(TAG, String.format("onCreate: %s",person.toString() ));
        }
    }
}
