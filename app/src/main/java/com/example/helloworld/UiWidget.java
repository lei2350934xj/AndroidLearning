package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class UiWidget extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_widget);

        /**
         *
         */
        TextView tx = findViewById(R.id.text_id);
        final String Label = tx.getText().toString();

        tx.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),
                        "You have clicked the Label : " + Label,
                        Toast.LENGTH_LONG).show();
            }
        });

        final EditText eText;
        final Button btn;

        eText = findViewById(R.id.edit1);
        btn = findViewById(R.id.btn_show_input);

        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,
                        Toast.LENGTH_LONG);
                msg.show();
                msg.show();
            }
        });

        final EditText edittext1 = findViewById(R.id.edittext_num1);
        final EditText edittext2 = findViewById(R.id.edittext_num2);
        Button btn_sum = findViewById(R.id.btn_sum);
        final EditText edittextresult = findViewById(R.id.edittext_result);
        btn_sum.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int num1 = Integer.parseInt(edittext1.getText().toString());
                int num2 = Integer.parseInt(edittext2.getText().toString());
                int result = num1 + num2;

                edittextresult.setText(String.valueOf(result));

            }
        });
        edittext1.setOnClickListener(new View.OnClickListener(){
           // 输入的时候 清空占位符
           public void onClick(View v){
                edittext1.setText("");
           }
        });
        edittext2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edittext2.setText("");
            }
        });

        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getBaseContext(),"你点了一个安卓图片",Toast.LENGTH_SHORT).show();
            }
        });

        addListenerRadioButton();   // 单选按钮的监听方法
    }

    private void addListenerRadioButton(){
        final RadioGroup radioGroupWebsite = findViewById(R.id.radioGroup1);
        Button btnWebsiteName = findViewById(R.id.button1);

        btnWebsiteName.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroupWebsite
                // 通过radioGroup拿到里面被选中的单选按钮的id
                int selected = radioGroupWebsite.getCheckedRadioButtonId();
                RadioButton radioBtn1 = findViewById(selected);
                Toast.makeText(getBaseContext(), radioBtn1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
