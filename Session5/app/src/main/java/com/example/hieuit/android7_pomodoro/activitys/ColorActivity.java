package com.example.hieuit.android7_pomodoro.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.ColorAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class ColorActivity extends AppCompatActivity {

    @BindView(R.id.rv_color)
    RecyclerView rvColor;

    private ColorAdapter colorAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        setupUI();

    }

    private void setupUI() {
        ButterKnife.bind(this);
        colorAdapter = new ColorAdapter();
        rvColor.setAdapter(colorAdapter);
        rvColor.setLayoutManager(new GridLayoutManager(this,4));
    }
}
