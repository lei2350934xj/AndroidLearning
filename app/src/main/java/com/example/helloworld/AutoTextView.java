package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoTextView extends Activity {

    private AutoCompleteTextView actv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_textview);

        String [] countries = getResources().getStringArray(R.array.country_arrays);
        actv = findViewById(R.id.autoCompleteTextView1);
        /**
         * ArrayAdapter的构造需要三个参数，
         * 依次为this,
         * 布局文件（注意这里的布局文件描述的是列表的每一行的布局，
         * android.R.layout.simple_list_item_1是系统定义好的布局文件只显示一行文字，
         * 数据源。
         */
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,countries);
        actv.setAdapter(adapter);

    }
}
