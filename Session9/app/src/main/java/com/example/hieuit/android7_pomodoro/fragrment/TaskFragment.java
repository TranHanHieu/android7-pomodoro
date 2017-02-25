package com.example.hieuit.android7_pomodoro.fragrment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.fragrment.strategies.AddTaskAction;
import com.example.hieuit.android7_pomodoro.fragrment.strategies.EditTaskAction;
import com.example.hieuit.android7_pomodoro.networks.NetContext;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginResponseJson;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.TaskJson;
import com.example.hieuit.android7_pomodoro.networks.services.AddTask;
import com.example.hieuit.android7_pomodoro.networks.services.TaskService;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

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
        downloadTasks();
        return view;
    }

    private void downloadTasks() {
        NetContext.instance
                .create(TaskService.class)
                .getAllTask()
                .enqueue(new Callback<List<TaskJson>>() {
                    @Override
                    public void onResponse(Call<List<TaskJson>> call, Response<List<TaskJson>> response) {
                        List<TaskJson> taskJsonList = response.body();
                        if (taskJsonList!=null){
                            DbContext.instance.cleanAlls();
                            for (TaskJson taskJson : taskJsonList) {
                                Task newTask = new Task(
                                        taskJson.getName(),
                                        taskJson.getColor(),
                                        (float)taskJson.getPaymentPerHour(),
                                        taskJson.isDone(),
                                        taskJson.getLocalId()

                                );
                                DbContext.instance.addTask(newTask);
                                taskAdapter.notifyDataSetChanged();//báp adapter cập nhật số luong item
                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<List<TaskJson>> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });
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

        taskAdapter.setTaskLongClickListener(new TaskAdapter.TaskLongClickListener() {
            @Override
            public void taskLongClick(final Task task) {

                AlertDialog dialogBox = new AlertDialog.Builder(getContext())
                        //set message, title, and icon
                        .setTitle("Delete")
                        .setMessage("Do you want to Delete")
                        .setIcon(R.drawable.ic_delete_black_24px)

                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                            public void onClick(final DialogInterface dialog, int whichButton) {
                                //your deleting code
                                dialog.dismiss();
                                NetContext.instance
                                        .create(TaskService.class)
                                        .deleteTask(task.getLocalId())
                                        .enqueue(new Callback<TaskJson>() {
                                            @Override
                                            public void onResponse(Call<TaskJson> call, Response<TaskJson> response) {
                                                Log.d(TaskFragment.class.toString(), "delete ! ");
                                                downloadTasks();
                                            }

                                            @Override
                                            public void onFailure(Call<TaskJson> call, Throwable t) {

                                            }
                                        });
                            }

                        })

                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                            }
                        })
                        .create();
                dialogBox.show();
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
