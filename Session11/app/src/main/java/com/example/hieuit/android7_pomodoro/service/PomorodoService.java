package com.example.hieuit.android7_pomodoro.service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.hieuit.android7_pomodoro.events.TimerCommandEvent;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Hieu It on 3/4/2017.
 */

public class PomorodoService extends Service {

    private CountDownTimer countDownTimer;
    @Override
    public void onCreate() {
        super.onCreate();
        //EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //EventBus.getDefault().unregister(this);

    }

    @Subscribe
    public void onCommand(TimerCommandEvent timerCommandEvent){
        Log.d(PomorodoService.class.toString(), "onCommand: hi");
    }



    private void starTimer(){
        countDownTimer = new CountDownTimer(100000,1000) {
            @Override
            public void onTick(long l) {
                Log.d("aaa", String.format("onTick: %s", l));
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
