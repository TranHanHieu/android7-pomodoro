package com.example.hieuit.android7_pomodoro.fragrment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.ColorAdapter;
import com.example.hieuit.android7_pomodoro.adapters.TaskAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetailFragment extends Fragment {

    @BindView(R.id.rv_color)
    RecyclerView rv_color;

    private ColorAdapter colorAdapter;

    public TaskDetailFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);
        setupUI(view);
        return view;
    }

    private void setupUI(View view) {
        ButterKnife.bind(this,view);
        colorAdapter = new ColorAdapter();
        rv_color.setAdapter(colorAdapter);
        rv_color.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv_color.setLayoutManager(new GridLayoutManager(this.getContext(),4));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Create new task");

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_edit_task,menu);
        menu.removeItem(R.id.action_settings);
    }
}
