package com.example.hieuit.android7_pomodoro.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.settings.SettingCredentials;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;

public class SettingActivity extends AppCompatActivity {

    private TextView tv_workTime;
    private TextView tv_break;
    private TextView tv_longBreak;
    private SeekBar sb_workTime;
    private SeekBar sb_break;
    private SeekBar sb_longBreak;
    private Spinner spinner;
    private Button bt_default;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getReferences();
        settupUI();
        addListeners();
    }

    private void settupUI() {
        String[] numbers = new String[]{
                "1", "2", "3",
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                numbers);
        spinner.setAdapter(arrayAdapter);
    }

    private void addListeners() {
        sb_workTime.setProgress(10);
        sb_break.setProgress(10);
        sb_longBreak.setProgress(10);
        if (SharedPrefs.getInstance().getSettingCredentials() != null) {
            SettingCredentials settingCredentials = SharedPrefs.getInstance().getSettingCredentials();
            this.sb_workTime.setProgress(Integer.valueOf(settingCredentials.getWorkTime()));
            this.sb_break.setProgress(Integer.valueOf(settingCredentials.getBreaks()));
            this.sb_longBreak.setProgress(Integer.valueOf(settingCredentials.getLongBreak()));
        }
        tv_workTime.setText(getResources().getString(R.string.Work_time) + sb_workTime.getProgress() + getResources().getString(R.string.mins));
        tv_break.setText(getResources().getString(R.string.Break) + sb_break.getProgress() + getResources().getString(R.string.mins));
        tv_longBreak.setText(getResources().getString(R.string.Long_break)+ sb_longBreak.getProgress() + getResources().getString(R.string.mins));

        bt_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb_workTime.setProgress(10);
                sb_break.setProgress(10);
                sb_longBreak.setProgress(10);
            }
        });

        sb_workTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_workTime.setText(getResources().getString(R.string.Work_time) + sb_workTime.getProgress() + getResources().getString(R.string.mins));
                SharedPrefs.getInstance().put(new SettingCredentials(String.valueOf(sb_workTime.getProgress()),
                        String.valueOf(sb_break.getProgress()),
                        String.valueOf(sb_longBreak.getProgress())));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_break.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_break.setText(getResources().getString(R.string.Break) + sb_break.getProgress() + getResources().getString(R.string.mins));
                SharedPrefs.getInstance().put(new SettingCredentials(String.valueOf(sb_workTime.getProgress()),
                        String.valueOf(sb_break.getProgress()),
                        String.valueOf(sb_longBreak.getProgress())));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_longBreak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_longBreak.setText(getResources().getString(R.string.Long_break)+ sb_longBreak.getProgress() + getResources().getString(R.string.mins));
                SharedPrefs.getInstance().put(new SettingCredentials(String.valueOf(sb_workTime.getProgress()),
                        String.valueOf(sb_break.getProgress()),
                        String.valueOf(sb_longBreak.getProgress())));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void getReferences() {

        tv_workTime = (TextView) findViewById(R.id.tv_worktime);
        tv_break = (TextView) findViewById(R.id.tv_break);
        tv_longBreak = (TextView) findViewById(R.id.tv_longbreak);
        sb_workTime = (SeekBar) findViewById(R.id.sb_worktime);
        sb_break = (SeekBar) findViewById(R.id.sb_break);
        sb_longBreak = (SeekBar) findViewById(R.id.sb_longbreak);
        spinner = (Spinner) findViewById(R.id.sp_break);
        bt_default = (Button) findViewById(R.id.bt_default);

    }
}
