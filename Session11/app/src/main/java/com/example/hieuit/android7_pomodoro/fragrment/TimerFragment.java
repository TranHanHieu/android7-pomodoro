package com.example.hieuit.android7_pomodoro.fragrment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.events.TimeProgress;
import com.example.hieuit.android7_pomodoro.events.TimerCommand;
import com.example.hieuit.android7_pomodoro.events.TimerCommandEvent;
import com.github.lzyzsd.circleprogress.DonutProgress;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    @BindView(R.id.bt_resume)
    ImageButton ibResume;
    @BindView(R.id.bt_stop)
    ImageButton ibStop;
    @BindView(R.id.dp_timer)
    DonutProgress dpTimer;


    public TimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        EventBus.getDefault().register(this);
        setupUI(view);
        dpTimer.setMax(1200000);

        addListenner();

        return view;
    }

    private void addListenner() {
        ibResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimerCommandEvent timerCommandEvent = new TimerCommandEvent(TimerCommand.RESUME_TIMER);
                EventBus.getDefault().post(timerCommandEvent);
            }
        });
        ibStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerCommandEvent timerCommandEvent = new TimerCommandEvent(TimerCommand.STOP_TIMER);
                EventBus.getDefault().post(timerCommandEvent);
            }
        });
    }

    @Subscribe
    public void setProgress(TimeProgress timeProgress){
        long milisecond = timeProgress.getMilisecond();
        long seconds = milisecond/1000;
        long minutes = (int) (seconds/60);
        dpTimer.setText(String.valueOf(minutes+" : " +((seconds-minutes*60) % 60)));
        dpTimer.setProgress(timeProgress.getMilisecond());
    }

    private void setupUI(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
