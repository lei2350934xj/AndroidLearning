package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SharePanel extends Activity {

    Button btn_call_share_panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        btn_call_share_panel = findViewById(R.id.btn_call_share_panel);
        btn_call_share_panel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");//intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, "嗨，我正在使用众意彩购买彩票，你也来试试手气哈！");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(Intent.createChooser(intent, getTitle()));
                startActivity(Intent.createChooser(intent, "分享"));
            }
        });
    }
}
