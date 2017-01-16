package com.example.hieuit.android7_pomodoro.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.settings.LoginCredentials;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.toString() ;
    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin;

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

        SharedPrefs sharedPrefs = new SharedPrefs(this);
        sharedPrefs.put(new LoginCredentials("hieu","xxx"));
        Log.d(TAG, String.format("object : %s",sharedPrefs.getLoginCredentials().toString()));
    }

    private void skipLoginIfPossible() {
        if (SharedPrefs.getInstance().getLoginCredentials() != null){
            gotoMainActivity();
        }
    }

    private void attemptLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        
        if (username.equals("admin")&&password.equals("admin")){
            //Notiffications
            SharedPrefs.getInstance().put(new LoginCredentials(username,password));
            gotoMainActivity();
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Logged failled", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(this,TaskActivity.class);
        startActivity(intent);
    }
}
