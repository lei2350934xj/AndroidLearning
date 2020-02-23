package com.example.helloworld;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CustomDateView extends TextView {
    public CustomDateView(Context context) {
        super(context);
        setDate();
    }

    public CustomDateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setDate();
    }

    public CustomDateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDate();
    }

    private void setDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String today = dateFormat.format(Calendar.getInstance().getTime());
        setText(today);
    }
}
