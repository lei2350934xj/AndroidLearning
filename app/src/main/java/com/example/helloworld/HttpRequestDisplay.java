package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static com.example.mysdk.HttpUtils.run;


public class HttpRequestDisplay extends Activity {

    Button btn_send_http_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        btn_send_http_request = findViewById(R.id.btn_send_http_request);
        btn_send_http_request.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String res;
                /**
                 * 这里调用自定义sdk中的get请求方法 run()
                 * 但是有报错 嘻嘻
                 */
                res = run("http://v.juhe.cn/toutiao/index");
                Toast.makeText(getApplicationContext(), "res="+res, Toast.LENGTH_LONG).show();
            }
        });
    }
}
