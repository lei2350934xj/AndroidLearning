package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InnerStorage extends Activity {

    private EditText et1, et2;
    private String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_storage);

        et1 = (findViewById(R.id.inner_storage_editText1));
        et2 = (findViewById(R.id.inner_storage_editText2));
    }

    public void save(View view){
        data = et1.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput(file,MODE_PRIVATE);
            fOut.write(data.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"file saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void read(View view){
        try{
            FileInputStream fin = openFileInput(file);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            et2.setText(temp);
            Toast.makeText(getBaseContext(),"file read", Toast.LENGTH_SHORT).show();

        }catch(Exception e){

        }
    }

}
