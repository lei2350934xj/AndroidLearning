package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

public class SpinnerDisplay extends Activity {

    boolean isSpinnerFirst = true ; // 第一次不展示下拉框的内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_display);

        final Spinner spinner = findViewById(R.id.btn_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isSpinnerFirst){
                    view.setVisibility(View.INVISIBLE);
                }else{
                    String str=parent.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(), "你点击的是:"+str, Toast.LENGTH_LONG).show();
                }
                isSpinnerFirst = false;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}