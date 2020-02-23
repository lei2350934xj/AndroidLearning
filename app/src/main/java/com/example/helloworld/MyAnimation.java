package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MyAnimation extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Button btn_rotate360 = findViewById(R.id.rotate360);
        btn_rotate360.setOnClickListener(this);

        Button btn_zoomInOut = findViewById(R.id.zoomInOut);
        btn_zoomInOut.setOnClickListener(this);

        Button btn_fadeInOut = findViewById(R.id.fadeInOut);
        btn_fadeInOut.setOnClickListener(this);
    }

    public void onClick(View v) {
        ImageView image;
        Animation animation;
        switch (v.getId()) {
            case R.id.zoomInOut:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                image = findViewById(R.id.imageView1);
                image.startAnimation(animation);
                break;
            case R.id.rotate360:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                image = findViewById(R.id.imageView1);
                image.startAnimation(animation);
                break;
            case R.id.fadeInOut:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                image = findViewById(R.id.imageView1);
                image.startAnimation(animation);
                break;
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        /**
//         * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。 返回true则显示该menu,false 则不显示;
//         * (只会在第一次初始化菜单时调用) Inflate the menu; this adds items to the action bar
//         * if it is present.
//        */
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.zoomInOut:
                ImageView image = findViewById(R.id.imageView1);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                image.startAnimation(animation);
                return true;
            case R.id.rotate360:
                ImageView image1 = findViewById(R.id.imageView1);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                image1.startAnimation(animation1);
                return true;
            case R.id.fadeInOut:
                ImageView image2 = findViewById(R.id.imageView1);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                image2.startAnimation(animation2);
                return true;
        }
        return false;
    }
}
