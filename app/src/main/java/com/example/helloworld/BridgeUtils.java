package com.example.helloworld;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class BridgeUtils {

    private Context context;
    public BridgeUtils(Context context){
        this.context = context;
    }

    //将显示Toast和对话框的方法暴露给JS脚本调用
    // 一定要加这个  @JavascriptInterface ，不然在html中找不到方法
    @JavascriptInterface
    public void showToast(String name) {
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface public void showDialog() {
        new AlertDialog.Builder(context)
                .setTitle("联系人列表").setIcon(R.mipmap.course)
                .setItems(new String[]{"基神", "B神", "曹神", "街神", "翔神"}, null)
                .setPositiveButton("确定", null).create().show();
    }
}
