package com.example.hieuit.android7_pomodoro.fragrment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.activitys.TaskActivity;
import com.example.hieuit.android7_pomodoro.adapters.TaskAdapter;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.fragrment.strategies.AddTaskAction;
import com.example.hieuit.android7_pomodoro.fragrment.strategies.EditTaskAction;
import com.example.hieuit.android7_pomodoro.networks.NetContext;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginResponseJson;
import com.example.hieuit.android7_pomodoro.networks.services.AddTask;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {

    @BindView(R.id.rv_task)
    RecyclerView rvTask;

    private TaskAdapter taskAdapter;
    FragmentListenner fragmentListenner;

    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        setupUI(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentListenner = (FragmentListenner) context;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);

        taskAdapter = new TaskAdapter();
        rvTask.setAdapter(taskAdapter);
        rvTask.setLayoutManager(new LinearLayoutManager(this.getContext()));
        taskAdapter.setTaskItemClickListenner(new TaskAdapter.TaskItemClickListenner() {
            @Override
            public void onItemClick(Task task) {

                TaskDetailFragment taskDetailFragment = new TaskDetailFragment();
                taskDetailFragment.setTitle("Edit task");
                taskDetailFragment.setTask(task);
                taskDetailFragment.setTaskAction(new EditTaskAction());


                //TODO: Make TaskActivity and fragment
                ((TaskActivity) getActivity()).replaceFragment(taskDetailFragment, true);
            }
        });

        taskAdapter.setTaskTimerListenner(new TaskAdapter.TaskTimerListenner() {
            @Override
            public void onStart(Task task) {
                Log.d(TaskFragment.class.toString(), "onStart: ");
                TimerFragment timerFragment = new TimerFragment();
                if (getActivity() instanceof TaskActivity) {
                    ((TaskActivity) getActivity()).getSupportActionBar().setTitle(R.string.timer_fragment);
                }
                //TODO: Make TaskActivity and fragment
                ((TaskActivity) getActivity()).replaceFragment(timerFragment, true);
            }
        });
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.tasks);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        rvTask.addItemDecoration(dividerItemDecoration);
        setHasOptionsMenu(true);//true thì oncreateoptionMune ms hđ.

    }

    @OnClick(R.id.fab)
    void onFabClick() {
        TaskDetailFragment taskDetailFragment = new TaskDetailFragment();
        taskDetailFragment.setTitle("Add new task");
        taskDetailFragment.setTaskAction(new AddTaskAction());
        //TODO: Make TaskActivity and fragment
        ((TaskActivity) getActivity()).replaceFragment(taskDetailFragment, true);
//        fragmentListenner.replaceFragment(taskDetailFragment,true);

    }

}
