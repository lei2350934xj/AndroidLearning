package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebviewJs extends Activity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_js);

        webview = findViewById(R.id.show_webview_js);
        webview.loadUrl("file:///android_asset/home.html");

        WebSettings webSettings = webview.getSettings();
        //①设置WebView允许调用js 下面几个都必须添加上
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //②将object对象暴露给Js,调用addjavascriptInterface
        webview.addJavascriptInterface(new BridgeUtils(WebviewJs.this),"BridgeUtils");
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

//    class MyAndroidUtils {
//        @JavascriptInterface
//        public void showMsg() {
//            Toast.makeText(getApplicationContext(), "Android.BridgeUtils", Toast.LENGTH_SHORT).show();
//        }
//    }
}
