package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonDisplay extends Activity {
    // 构造JSON对象 参数是一个json字符串
    private JSONObject reader = new JSONObject("{\n" +
            "\t\"beijing\": {\n" +
            "\t\t\"id\": \"1\",\n" +
            "\t\t\"temperature\": \"22\"\n" +
            "\t},\n" +
            "\t\"shanghai\": {\n" +
            "\t\t\"id\": \"2\",\n" +
            "\t\t\"temperature\": \"19\"\n" +
            "\t},\n" +
            "\t\"chengdu\": {\n" +
            "\t\t\"id\": \"2\",\n" +
            "\t\t\"temperature\": \"27\"\n" +
            "\t}\n" +
            "}");

    public JsonDisplay() throws JSONException {
    }

    private EditText json_editview1;
    private EditText json_editview2;
    private String temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        json_editview1 = findViewById(R.id.json_editview1);
        json_editview2 = findViewById(R.id.json_editview2);
    }

    public void json_search_city(View v) throws JSONException {
        String target_city = json_editview1.getText().toString();
        /**
         *          解析json两步：
         *          1.new JSONObject
         *          2.
         *          JSONObject sys  = reader.getJSONObject("sys");
         *          country = sys.getString("country");
         */
        JSONObject info  = reader.getJSONObject(target_city);   // 根据你输入的内容进行JSON数据的查找解析
        temperature = info.getString("temperature");
        json_editview2.setText("temperature:"+temperature);
    }

}
