package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntentServiceView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        // 创建service的intent 存好数据 在service中使用
        Intent it1 = new Intent(this, IntentServiceDisplay.class);
        it1.putExtra("param", "s1");
        Intent it2 = new Intent(this, IntentServiceDisplay.class);
        it2.putExtra("param", "s2");
        Intent it3 = new Intent(this, IntentServiceDisplay.class);
        it3.putExtra("param", "s3");

        startService(it1);
        startService(it2);
        startService(it3);
    }
}
