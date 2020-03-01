package com.example.helloworld;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProviderDisplay extends Activity {

    EditText provider_number;
    TextView provider_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        provider_number = findViewById(R.id.provider_number);
        provider_content = findViewById(R.id.provider_content);

    }

    private void showContacts() {

    }

    public void search_number(View v){
        /**
         * Android虚拟机权限需要手动添加：
         * 在 所有应用 中，找到你的程序，然后手动添加 “权限”，钩选“通讯录”即可
         */
        Uri uri = Uri.parse("content://com.android.contacts/data/phones/filter/" + provider_number.getText().toString());
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{"display_name"}, null, null, null);
        // cursor.moveToFirst() 为false 则没有找到对应的联系人
        if (cursor.moveToFirst()) {
            String name = cursor.getString(0);
            System.out.println(provider_number + "对应的联系人名称：" + name);
            provider_content.setText(provider_number+"对应的联系人名称："+name);
        }else{
            System.out.println("对应的联系人名称：" + cursor.moveToFirst());
            provider_content.setText("对不起没有找到对应的联系人");
        }
        cursor.close();
    }

}
