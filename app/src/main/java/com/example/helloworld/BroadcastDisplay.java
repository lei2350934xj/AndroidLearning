package com.example.helloworld;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastDisplay extends Activity {

    MyBRReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Button btn_dynamic = findViewById(R.id.btn_dynamic);
        Button btn_static = findViewById(R.id.btn_static);
        Button btn_send_broadcast = findViewById(R.id.btn_send_broadcast);

        btn_dynamic.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //核心部分代码：
                myReceiver = new MyBRReceiver();
                IntentFilter itFilter = new IntentFilter();
                itFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                registerReceiver(myReceiver, itFilter);
            }
        });
        btn_static.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //
            }
        });
        btn_send_broadcast.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent("MY_CUSTOM_BROADCAST");
                /**
                 * Android8上新特性 必须加入ComponentName
                 * 参数1是自定义广播的包名，参数2是自定义广播的路径
                 */
                intent.setComponent(new ComponentName("com.example.helloworld", "com.example.helloworld.MyBroadcastReceiver"));
                sendBroadcast(intent);
            }
        });

    }
}
