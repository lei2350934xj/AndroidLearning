package com.example.helloworld;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

public class Notification extends Activity {

    private NotificationManager mNotificationManager;
    private int notificationID = 100;
    private int numMessages = 0;
    public static String CALENDAR_ID = "channel_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button btn_send_message = findViewById(R.id.btn_send_message);
        btn_send_message.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    protected void displayNotification(){

        Log.i("Start", "notification");
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //8.0 以后需要加上channelId 才能正常显示
        /**
         * 每次进行通知触发时，对系统版本进行判断，8.0及以上需要设置好“channelId”（没有特殊要求、唯一即
         * 可）、“channelName”（用户看得到的信息）、“importance”（重要等级）这三个重要参数，然后创
         * 建到NotificationManager
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = "default";
            String channelName = "默认通知";
            manager.createNotificationChannel(new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH));
        }

        //设置TaskStackBuilder
        /**
         * TaskStackBuilder 作用是打开跳转页面点击返回时回到指定页面
         */
        Intent notification_view = new Intent(this, NotificationView.class);    // 要跳转的activity
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationView.class);
        stackBuilder.addNextIntent(notification_view);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // 这里是创建通知并设置属性
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "default");
        notification.setSmallIcon(R.mipmap.ic_baocai);
        notification.setContentTitle("标题");
        notification.setContentText("这是内容，点击我可以跳转");
        notification.setAutoCancel(true);
        notification.setWhen(System.currentTimeMillis());
        notification.setContentIntent(pendingIntent);   // 这个是配合 TaskStackBuilder 做跳转用的

        manager.notify(1, notification.build());

    }

}
