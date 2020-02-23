package com.example.helloworld;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;

public class AudioDisplay extends Activity {

    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    private Button start,stop,play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        start = findViewById(R.id.btn_start);
        stop = findViewById(R.id.btn_stop);
        play = findViewById(R.id.btn_play);

        stop.setEnabled(false);
        play.setEnabled(false);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myrecording.3gp";

        /**
         * android 版本6.0以上 需要动态获取权限 这一步必须在创建音频对象之前完成
         */
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);


    }

        public void start(View view){
            try {
                myAudioRecorder.prepare();
                myAudioRecorder.start();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            start.setEnabled(false);
            stop.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();

        }

        public void stop(View view){
            myAudioRecorder.stop();
            myAudioRecorder.release();
            myAudioRecorder  = null;
            stop.setEnabled(false);
            play.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Audio recorded successfully",
                    Toast.LENGTH_LONG).show();
        }

        public void play(View view) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
            MediaPlayer m = new MediaPlayer();
            m.setDataSource(outputFile);
            m.prepare();
            m.start();
            Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
        }
}
