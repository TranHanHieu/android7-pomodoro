package com.example.hieuit.android7_pomodoro.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginResponseJson;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.LoginBodyJson;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.RegisterBodyJson;
import com.example.hieuit.android7_pomodoro.networks.jsonmodels.RegisterResponseJson;
import com.example.hieuit.android7_pomodoro.networks.services.LoginService;
import com.example.hieuit.android7_pomodoro.networks.services.RegisterService;
import com.example.hieuit.android7_pomodoro.settings.LoginCredentials;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;
import com.google.gson.Gson;

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
    private Button btRegister;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //skipLoginIfPossible();
        setContentView(R.layout.activity_login);
        etUsername = (EditText) this.findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        btRegister = (Button) findViewById(R.id.bt_register);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

    }

    private void attemptRegister() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        sendRegister(username,password);

    }

    private void sendRegister(String username, String password){
        retrofit = new Retrofit.Builder().baseUrl("http://a-task.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterService registerService = retrofit.create(RegisterService.class);
        MediaType jsonType = MediaType.parse("application/json");
        String registerJson = (new Gson().toJson(new RegisterBodyJson(username,password)));
        RequestBody registerBody = RequestBody.create(jsonType, registerJson);
        registerService.register(registerBody).enqueue(new Callback<RegisterResponseJson>() {
            @Override
            public void onResponse(Call<RegisterResponseJson> call, Response<RegisterResponseJson> response) {
                RegisterResponseJson registerResponseJson = response.body();
                if (registerResponseJson == null){
                    Toast.makeText(LoginActivity.this,"Register onResponse: could not parse body !",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Register onResponse: could not parse body ");
                }else {
                    if (response.code()==200) {
                        Toast.makeText(LoginActivity.this,"Register Success !",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Register Success");
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterResponseJson> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Register onFailure !",Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Register onFailure ");
            }
        });

    }

    private void sendLogin(String username, String password) {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://a-task.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService loginService = retrofit.create(LoginService.class);

        // data && format
        // format => MediaType
        // data => json
        MediaType jsonType = MediaType.parse("application/json");
        String loginJson = (new Gson().toJson(new LoginBodyJson(username, password)));
        RequestBody loginBody = RequestBody.create(jsonType, loginJson);

        loginService.login(loginBody).enqueue(new Callback<LoginResponseJson>() {
            @Override
            public void onResponse(Call<LoginResponseJson> call, Response<LoginResponseJson> response) {
                LoginResponseJson loginResponseJson = response.body();
                if (loginResponseJson == null) {
                    Toast.makeText(LoginActivity.this,"Login onResponse: could not parse body !",Toast.LENGTH_SHORT);
                    Log.d(TAG, "onResponse: could not parse body");
                } else {
                    Log.d(TAG, "onResponse: oh year");
                    if (response.code() == 200) {
                        onLoginSuccess();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponseJson> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Login onFailure !",Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure");
            }
        });
    }

    private void onLoginSuccess() {
        SharedPrefs.getInstance().put(new LoginCredentials(username, password));
        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
        gotoMainActivity();
    }

    private String username;
    private String password;

    private void skipLoginIfPossible() {
        if (SharedPrefs.getInstance().getLoginCredentials() != null) {
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
        startActivity(intent);
    }
}
