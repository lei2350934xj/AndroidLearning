package com.example.helloworld;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClipboardDisplay extends Activity {

    private ClipboardManager myClipboard;
    private ClipData myClip;
    private EditText copyField,pasteField;

    public ClipboardDisplay() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipboard);

        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        copyField = findViewById(R.id.clipboard_editText1);
        pasteField = findViewById(R.id.clipboard_editText2);
    }

    public void copy_text(View v){
        String text = copyField.getText().toString();
        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);     // 将数据设置为剪贴板管理器对象的剪辑
        Toast.makeText(getApplicationContext(), "Text Copied",
                Toast.LENGTH_SHORT).show();
    }
    public void paste_text(View v) {
        /**
         * 先要通过调用getPrimaryClip()方法拿到剪辑。并从点击就可 ClipData.Item 对象的项目。从对象将得到数据
         */
        ClipData abc = myClipboard.getPrimaryClip();
        ClipData.Item item = abc.getItemAt(0);
        String text = item.getText().toString();
        pasteField.setText(text);
        Toast.makeText(getApplicationContext(), "Text Pasted",
                Toast.LENGTH_SHORT).show();
    }
}
