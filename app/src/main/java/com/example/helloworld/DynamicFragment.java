package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;

public class DynamicFragment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        Display dis = getWindowManager().getDefaultDisplay();
        if(dis.getWidth() > dis.getHeight())
        {
            FragmentTablet tablet = new FragmentTablet();
            getFragmentManager().beginTransaction().replace(R.id.dynamic_fragment_content, tablet).commit();
        }

        else
        {
            FragmentHandset handset = new FragmentHandset();
            getFragmentManager().beginTransaction().replace(R.id.dynamic_fragment_content, handset).commit();
        }
    }
}
