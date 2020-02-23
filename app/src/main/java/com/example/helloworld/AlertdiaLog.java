package com.example.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertdiaLog extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }
    public void open(View v){
        // 1.使用一个警告对话框，需要一个AlertDialogBuilder对象使用它的内部类AlertDialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.decision);
        // 2.
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "You have clicked the Label : Yes" , Toast.LENGTH_LONG).show();
//                Intent positveActivity = new Intent(getApplicationContext(),com.example.alertdialog.PositiveActivity.class);
//                startActivity(positveActivity);
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "You have clicked the Label : No" , Toast.LENGTH_LONG).show();
            }
        });
        // 3.创建和设置对话框构建器之后，将通过调用生成器类的 create()方法创建一个警告对话框
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
