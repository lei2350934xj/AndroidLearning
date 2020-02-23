package com.example.helloworld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginDisplay extends Activity {

    private EditText username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button login;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username_edit);
        password = findViewById(R.id.login_password_edit);
        attempts = findViewById(R.id.login_attempt_counts);
        attempts.setText(Integer.toString(counter));
        login = findViewById(R.id.btn_submit_login);
    }

    public void submit_login(View v){
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(), "跳转中...",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "账户名或密码错误",
                    Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor(Color.RED);
            counter--;
            attempts.setText(Integer.toString(counter));
            if(counter==0){
                login.setEnabled(false);
            }
        }
    }
}
