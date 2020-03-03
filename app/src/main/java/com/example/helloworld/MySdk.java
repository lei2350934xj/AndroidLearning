package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.mysdk.MyUtils.add;

public class MySdk extends Activity {

    Button btn_mysdk_add;
    private int a = 1, b = 2;
    private int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_mysdk);

        btn_mysdk_add = findViewById(R.id.btn_mysdk_add);
        btn_mysdk_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                res = add(a,b);
//                String temp = String.valueOf(res);
                Toast.makeText(getApplicationContext(), "res="+res, Toast.LENGTH_LONG).show();
            }
        });
    }
}
