package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class LoadingSpinnerDisplay extends Activity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_spinner);

        spinner = findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
    }

    public void load(View v){
        spinner.setVisibility(View.VISIBLE);
    }
}
