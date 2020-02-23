package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityCommunicateSub extends Activity {

    private TextView activity_communicate_sub_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_communicate_sub);

        activity_communicate_sub_label = findViewById(R.id.activity_communicate_sub_label);
        /**
         * 取数据
         * 不同类型的改方法getStringExtra()即可
         * 例如getIntExtra()
         */
        Intent data = getIntent();
        String name = data.getStringExtra("name");
        activity_communicate_sub_label.setText(name);
    }
}
