package com.example.hieuit.android7_pomodoro.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hieuit.android7_pomodoro.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btRegister;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (!username.equals("admin") && !username.isEmpty() && !password.isEmpty()) {
            //Notiffications
            Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Registered failled", Toast.LENGTH_SHORT).show();
        }
    }

    private void attemptLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.equals("admin") && password.equals("admin")) {
            //Notiffications
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Logged failled", Toast.LENGTH_SHORT).show();
        }
    }
}
