package com.example.helloworld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.ClipData;
import android.content.ClipDescription;
import android.view.DragEvent;
import android.util.Log;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class DragDrop extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);

        final String msg = "";
        final String IMAGEVIEW_TAG = "Android Logo";
        android.widget.RelativeLayout.LayoutParams layoutParams;

        ImageView ima = findViewById(R.id.iv_logo);
        // 1.为ImageView绑定长点击事件
        ima.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(msg,"点击了ImageView");
                //创建移动数据
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData dragData = new ClipData(IMAGEVIEW_TAG, mimeTypes, item);

                // 调用startDrag方法
                v.startDragAndDrop(dragData,  // the data to be dragged
                        new View.DragShadowBuilder(v),  // the drag shadow builder
                        null,      // no need to use local data
                        0          // flags (not currently used, set to 0)
                );
                return true;
            }
        });
        // 2.为目标View绑定拖拽监听
        final RelativeLayout topContainer = findViewById(R.id.topContainer);
        topContainer.setOnDragListener(new OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                switch(event.getAction())
                {
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        //被拖放View进入目标View
//                        topContainer.setBackgroundColor(Color.YELLOW);
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION  :
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        break;
                    case DragEvent.ACTION_DRAG_EXITED :
                        //被拖放View离开目标View
//                        topContainer.setBackgroundColor(Color.BLUE);
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        layoutParams.leftMargin = x_cord;
                        layoutParams.topMargin = y_cord;
                        v.setLayoutParams(layoutParams);
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        break;
                    case DragEvent.ACTION_DROP:
//                        x_cord = (int) event.getX();
//                        y_cord = (int) event.getY();
//                        layoutParams.leftMargin = x_cord;
//                        layoutParams.topMargin = y_cord;
//                        v.setLayoutParams(layoutParams);
                        Log.d(msg, "ACTION_DROP event");
                        break;
                    case DragEvent.ACTION_DRAG_ENDED   :
                        //拖放事件完成
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                        break;
                    default: break;
                }
                return true;
            }
        });
    }
}
