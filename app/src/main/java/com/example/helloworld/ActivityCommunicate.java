package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCommunicate extends Activity {
    private EditText activity_communicate_content;
    private Button btn_activity_communicate_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_communicate);

        activity_communicate_content = findViewById(R.id.activity_communicate_content);

    }
    public void activity_communicate_submit(View v){
        /**
         * 1.拿到EditText 中的name
         * 2.存数据
         */
        String name = activity_communicate_content.getText().toString();
        Intent activity_communicate_sub = new Intent(this, ActivityCommunicateSub.class);
        activity_communicate_sub.putExtra("name", name);
        startActivity(activity_communicate_sub);
        Log.d("提交的名字是", name);
    }
}
