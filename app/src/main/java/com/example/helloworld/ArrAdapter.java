package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class ArrAdapter extends Activity {

    String[] countryArray = {"China", "India", "Pakistan", "USA", "UK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, countryArray);

        ListView listView = findViewById(R.id.country_list);
        listView.setAdapter(adapter);
    }
}
