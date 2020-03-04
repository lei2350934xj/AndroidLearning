package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class WebviewDisplay extends Activity {

    Button btn_load_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        btn_load_page = findViewById(R.id.btn_load_page);
        btn_load_page.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //获得控件
                WebView webview = findViewById(R.id.show_webview);
                //访问网页
                webview.loadUrl("https://www.baidu.com");
                //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
                webview.setWebViewClient(new WebViewClient(){
                    @Override
                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                         //使用WebView加载显示url
                         view.loadUrl(url);
                         //返回true
                        return true;
                    }
                });
            }
        });
    }

}
