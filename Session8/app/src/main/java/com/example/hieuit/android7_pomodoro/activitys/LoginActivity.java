package com.example.hieuit.android7_pomodoro.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.networks.NetContext;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginResponseJson;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginBodyJson;
import com.example.hieuit.android7_pomodoro.networks.services.GetAllTask;
import com.example.hieuit.android7_pomodoro.networks.services.LoginService;
import com.example.hieuit.android7_pomodoro.settings.LoginCredentials;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.toString();
    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin;
    private Retrofit retrofit;
    private String username;
    private String password;
    private String accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        skipLoginIfPossible();
        setContentView(R.layout.activity_login);
        etUsername = (EditText) this.findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

    }

    private void sendLogin(String username, String password) {
        //1. create (base url)
        retrofit = new Retrofit.Builder()
                .baseUrl("http://a-task.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //2.create service
        LoginService loginService = retrofit.create(LoginService.class);

        // data && format
        // format => MediaType
        // data => json
        MediaType jsonType = MediaType.parse("application/json");
        String loginJson = (new Gson().toJson(new LoginBodyJson(username, password)));
        RequestBody loginBody = RequestBody.create(jsonType, loginJson);


        //enqueue tự động mở luồng phụ.
        //execute chạy trên luồng chính.
        //3. create call.
        Call<LoginResponseJson> loginCall = loginService.login(loginBody);
        loginCall.enqueue(new Callback<LoginResponseJson>() {
            @Override
            public void onResponse(Call<LoginResponseJson> call, Response<LoginResponseJson> response) {
                LoginResponseJson loginResponseJson = response.body();
                if (loginResponseJson == null) {
                    Log.d(TAG, "onResponse: could not parse body");
                } else {
                    Log.d(TAG, "onResponse: oh year");
                    if (response.code() == 200) {
                        accessToken = loginResponseJson.getAccessToken();
                        onLoginSuccess();
                    }
                }
                Log.d(TAG, "onResponse");
            }

            @Override
            public void onFailure(Call<LoginResponseJson> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }

    private void onLoginSuccess() {
        SharedPrefs.getInstance().put(new LoginCredentials(username, password, accessToken));
        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
        getAllTask();
        gotoMainActivity();
    }

    public void getAllTask(){
        GetAllTask getAllTaskService = NetContext.instance.getRetrofit().create(GetAllTask.class);
        String accessToken = "JWT " + SharedPrefs.getInstance().getAccessToken();
        Call<List<Task>> getAllTask = getAllTaskService.getAllTask(accessToken);
        getAllTask.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                Log.d(TAG, "onResponse hhhhhhh: ");

                if (response.body() != null) {
                    for (Task task : response.body()) {
                        if (task != null) {
                            DbContext.instance.addTask(task);
                            Log.d(TAG, "onResponse hhhhhhh: " + response.body().toString());
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {

                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void skipLoginIfPossible() {
        if (SharedPrefs.getInstance().getAccessToken() != null) {
            getAllTask();
            gotoMainActivity();
        }
    }

    private void attemptLogin() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        sendLogin(username, password);
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(this, TaskActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//báo cho k lưu vào stack.
        startActivity(intent);
    }
}
