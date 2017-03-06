package com.example.hieuit.android7_pomodoro.service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.hieuit.android7_pomodoro.events.TimeProgress;
import com.example.hieuit.android7_pomodoro.events.TimerCommand;
import com.example.hieuit.android7_pomodoro.events.TimerCommandEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Hieu It on 3/4/2017.
 */

public class PomorodoService extends Service {

    private CountDownTimer countDownTimer;
    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Subscribe
    public void onCommand(TimerCommandEvent timerCommandEvent){
        Log.d(PomorodoService.class.toString(), "onCommand: hi");
        if (timerCommandEvent.getCommand().equals(TimerCommand.START_TIMER)){
            starTimer();
        }else if (timerCommandEvent.getCommand().equals(TimerCommand.STOP_TIMER)){
            stopTimer();
        }else if (timerCommandEvent.getCommand().equals(TimerCommand.RESUME_TIMER)){
            resumeTimer();
        }
    }

    private void resumeTimer() {
        setStop();
        starTimer();
    }

    private void stopTimer() {
        setStop();
    }

    private long tempTime;
    private boolean isStop;
    private static long MAX =1200000;

    public void setStop() {
        isStop = !isStop;
    }

    private void starTimer(){
        countDownTimer = new CountDownTimer(MAX,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("aaa", String.format("onTick: %s", millisUntilFinished));
                TimeProgress timeProgress = new TimeProgress(0);
                if (!isStop) {
                    timeProgress = new TimeProgress(millisUntilFinished);
                    tempTime = millisUntilFinished;
                }else {
                    timeProgress = new TimeProgress(tempTime);
                    MAX =millisUntilFinished;
                    countDownTimer.cancel();
                }
                EventBus.getDefault().post(timeProgress);
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
