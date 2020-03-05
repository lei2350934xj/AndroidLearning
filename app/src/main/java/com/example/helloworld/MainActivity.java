package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    /**
     *  在方法前面加上@Override 系统可以帮你检查方法的正确性
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
//        setContentView(R.layout.activity_relative_layout);
//        setContentView(R.layout.activity_ui);
//        setContentView(R.layout.activity_event_demo);

        // Activity本身作为事件监听器类 必须实现implements OnClickListener 并且导入 android.view.View.OnClickListener;
        Button btn_ui_learning = findViewById(R.id.btn_ui_learning);
        btn_ui_learning.setOnClickListener(this);

        Button btn_ui_widget = findViewById(R.id.btn_ui_widget);
        btn_ui_widget.setOnClickListener(this);

        Button btn_custom_widget = findViewById(R.id.btn_custom_widget);
        btn_custom_widget.setOnClickListener(this);

        Button btn_drag_drop = findViewById(R.id.btn_drag_drop);
        btn_drag_drop.setOnClickListener(this);

        Button btn_notification = findViewById(R.id.btn_notification);
        btn_notification.setOnClickListener(this);

        Button btn_arrayadapter = findViewById(R.id.btn_arrayadapter);
        btn_arrayadapter.setOnClickListener(this);

        Button btn_progress_dialog = findViewById(R.id.btn_progress_dialog);
        btn_progress_dialog.setOnClickListener(this);

        Button btn_spinner = findViewById(R.id.btn_spinner);
        btn_spinner.setOnClickListener(this);

        Button btn_alert_dialog = findViewById(R.id.btn_alert_dialog);
        btn_alert_dialog.setOnClickListener(this);

        Button btn_animation = findViewById(R.id.btn_animation);
        btn_animation.setOnClickListener(this);

        Button btn_audio = findViewById(R.id.btn_audio);
        btn_audio.setOnClickListener(this);

        Button btn_auto_complete_textview = findViewById(R.id.btn_auto_complete_textview);
        btn_auto_complete_textview.setOnClickListener(this);

        Button btn_bluetooth = findViewById(R.id.btn_bluetooth);
        btn_bluetooth.setOnClickListener(this);

        Button btn_clipboard = findViewById(R.id.btn_clipboard);
        btn_clipboard.setOnClickListener(this);

        Button btn_gestures = findViewById(R.id.btn_gestures);
        btn_gestures.setOnClickListener(this);

        Button btn_bitmap = findViewById(R.id.btn_bitmap);
        btn_bitmap.setOnClickListener(this);

        Button btn_inner_storage = findViewById(R.id.btn_inner_storage);
        btn_inner_storage.setOnClickListener(this);

        Button btn_json = findViewById(R.id.btn_json);
        btn_json.setOnClickListener(this);

        Button btn_loading_spinner = findViewById(R.id.btn_loading_spinner);
        btn_loading_spinner.setOnClickListener(this);

        Button btn_localization = findViewById(R.id.btn_localization);
        btn_localization.setOnClickListener(this);

        Button btn_login_display = findViewById(R.id.btn_login_display);
        btn_login_display.setOnClickListener(this);

        Button btn_media_player = findViewById(R.id.btn_media_player);
        btn_media_player.setOnClickListener(this);

        Button btn_activity = findViewById(R.id.btn_activity);
        btn_activity.setOnClickListener(this);

        Button btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);

        Button btn_activity_communicate = findViewById(R.id.btn_activity_communicate);
        btn_activity_communicate.setOnClickListener(this);

        Button btn_drawerLayout = findViewById(R.id.btn_drawerLayout);
        btn_drawerLayout.setOnClickListener(this);

        Button btn_service = findViewById(R.id.btn_service);
        btn_service.setOnClickListener(this);

        Button btn_intent_service = findViewById(R.id.btn_intent_service);
        btn_intent_service.setOnClickListener(this);

        Button btn_intent_broadcast = findViewById(R.id.btn_broadcast);
        btn_intent_broadcast.setOnClickListener(this);

        Button btn_intent_provider = findViewById(R.id.btn_provider);
        btn_intent_provider.setOnClickListener(this);

        Button btn_intent_fragment = findViewById(R.id.btn_fragment);
        btn_intent_fragment.setOnClickListener(this);

        Button btn_intent_fragment_dynamic = findViewById(R.id.btn_fragment_dynamic);
        btn_intent_fragment_dynamic.setOnClickListener(this);

        Button btn_intent_mysdk = findViewById(R.id.btn_mysdk);
        btn_intent_mysdk.setOnClickListener(this);

        Button btn_intent_webview = findViewById(R.id.btn_webview);
        btn_intent_webview.setOnClickListener(this);

        Button btn_intent_webview_js = findViewById(R.id.btn_webview_js);
        btn_intent_webview_js.setOnClickListener(this);

        Button btn_intent_share = findViewById(R.id.btn_share);
        btn_intent_share.setOnClickListener(this);

        Button btn_intent_http_request_display = findViewById(R.id.btn_http_request_display);
        btn_intent_http_request_display.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ui_learning :
                /**
                 *  从另一个 Activity 中启动某个 Activity
                 *  参数一：包名
                 *  参数二：类名 ==》从而限定要启动哪个activity
                 */
                Intent intent_ui_learning = new Intent(MainActivity.this, UiLearning.class);
                startActivity(intent_ui_learning);
                break;
            case R.id.btn_ui_widget :
                Intent intent_ui_widget = new Intent(MainActivity.this, UiWidget.class);
                startActivity(intent_ui_widget);
                break;
            case R.id.btn_custom_widget :
                Intent intent_custom_widget = new Intent(MainActivity.this, CustomWidget.class);
                startActivity(intent_custom_widget);
                break;
            case R.id.btn_drag_drop :
                Intent intent_drag_drop = new Intent(MainActivity.this, DragDrop.class);
                startActivity(intent_drag_drop);
                break;
            case R.id.btn_notification:
                Intent intent_notification = new Intent(MainActivity.this, Notification.class);
                startActivity(intent_notification);
                break;
            case R.id.btn_arrayadapter:
                Intent intent_arrayadapter = new Intent(MainActivity.this, ArrAdapter.class);
                startActivity(intent_arrayadapter);
                break;
            case R.id.btn_progress_dialog:
                Intent intent_progress_dialog = new Intent(MainActivity.this, ProDialog.class);
                startActivity(intent_progress_dialog);
                break;
            case R.id.btn_spinner:
                Intent intent_spinner = new Intent(MainActivity.this, SpinnerDisplay.class);
                startActivity(intent_spinner);
                break;
            case R.id.btn_alert_dialog:
                Intent intent_alert_dialog = new Intent(MainActivity.this, AlertdiaLog.class);
                startActivity(intent_alert_dialog);
                break;
            case R.id.btn_animation:
                Intent intent_animation = new Intent(MainActivity.this, MyAnimation.class);
                startActivity(intent_animation);
                break;
            case R.id.btn_audio:
                Intent intent_audio = new Intent(MainActivity.this, AudioDisplay.class);
                startActivity(intent_audio);
                break;
            case R.id.btn_auto_complete_textview:
                Intent intent_auto_complete_textview = new Intent(MainActivity.this, AutoTextView.class);
                startActivity(intent_auto_complete_textview);
                break;
            case R.id.btn_bluetooth:
                Intent intent_bluetooth = new Intent(MainActivity.this, BluetoothDisplay.class);
                startActivity(intent_bluetooth);
                break;
            case R.id.btn_clipboard:
                Intent intent_clipboard = new Intent(MainActivity.this, ClipboardDisplay.class);
                startActivity(intent_clipboard);
                break;
            case R.id.btn_gestures:
                Intent intent_gestures = new Intent(MainActivity.this, GesturesDisplay.class);
                startActivity(intent_gestures);
                break;
            case R.id.btn_bitmap:
                Intent intent_bitmap = new Intent(MainActivity.this, BitmapDisplay.class);
                startActivity(intent_bitmap);
                break;
            case R.id.btn_inner_storage:
                Intent intent_inner_storage = new Intent(MainActivity.this, InnerStorage.class);
                startActivity(intent_inner_storage);
                break;
            case R.id.btn_json:
                Intent intent_json = new Intent(MainActivity.this, JsonDisplay.class);
                startActivity(intent_json);
                break;
            case R.id.btn_loading_spinner:
                Intent intent_loading_spinner = new Intent(MainActivity.this, LoadingSpinnerDisplay.class);
                startActivity(intent_loading_spinner);
                break;
            case R.id.btn_localization:
                Intent intent_localization = new Intent(MainActivity.this, LocalizationDisplay.class);
                startActivity(intent_localization);
                break;
            case R.id.btn_login_display:
                Intent intent_login_display = new Intent(MainActivity.this, LoginDisplay.class);
                startActivity(intent_login_display);
                break;
            case R.id.btn_media_player:
                Intent intent_media_player = new Intent(MainActivity.this, MediaPlayerDisplay.class);
                startActivity(intent_media_player);
                break;
            case R.id.btn_activity:
                Intent intent_activity = new Intent(MainActivity.this, ActivityDisplay.class);
                startActivity(intent_activity);
                // 为Activity设置过场动画
                overridePendingTransition(R.anim.fade, 0);
                break;
            case R.id.btn_menu:
                Intent intent_menu = new Intent(MainActivity.this, MenuDisplay.class);
                startActivity(intent_menu);
                break;
            case R.id.btn_activity_communicate:
                Intent intent_activity_communicate = new Intent(MainActivity.this, ActivityCommunicate.class);
                startActivity(intent_activity_communicate);
                break;
            case R.id.btn_drawerLayout:
                Intent intent_drawerLayout = new Intent(MainActivity.this, DrawerLayoutDisplay.class);
                startActivity(intent_drawerLayout);
                break;
            case R.id.btn_service:
                Intent intent_service = new Intent(MainActivity.this, ServiceView.class);
                startActivity(intent_service);
                break;
            case R.id.btn_intent_service:
                Intent intent_intent_service = new Intent(MainActivity.this, IntentServiceView.class);
                startActivity(intent_intent_service);
                break;
            case R.id.btn_broadcast:
                Intent intent_broadcast = new Intent(MainActivity.this, BroadcastDisplay.class);
                startActivity(intent_broadcast);
                break;
            case R.id.btn_provider:
                Intent intent_provider = new Intent(MainActivity.this, ProviderDisplay.class);
                startActivity(intent_provider);
                break;
            case R.id.btn_fragment:
                Intent intent_fragment = new Intent(MainActivity.this, FragmentDisplay.class);
                startActivity(intent_fragment);
                break;
            case R.id.btn_fragment_dynamic:
                Intent intent_fragment_dynamic = new Intent(MainActivity.this, DynamicFragment.class);
                startActivity(intent_fragment_dynamic);
                break;
            case R.id.btn_mysdk:
                Intent intent_mysdk = new Intent(MainActivity.this, MySdk.class);
                startActivity(intent_mysdk);
                break;
            case R.id.btn_webview:
                Intent intent_webview = new Intent(MainActivity.this, WebviewDisplay.class);
                startActivity(intent_webview);
                break;
            case R.id.btn_webview_js:
                Intent intent_webview_js = new Intent(MainActivity.this, WebviewJs.class);
                startActivity(intent_webview_js);
                break;
            case R.id.btn_share:
                Intent intent_share = new Intent(MainActivity.this, SharePanel.class);
                startActivity(intent_share);
                break;
            case R.id.btn_http_request_display:
                Intent intent_http_request_display = new Intent(MainActivity.this, HttpRequestDisplay.class);
                startActivity(intent_http_request_display);
                break;
        }

    }


    // 自定义事件监听和处理函数
//    private void addListenerOnButton(){
//        Button btn_add = (Button)findViewById(R.id.btn_add);
//        Button btn_del = (Button)findViewById(R.id.btn_del);
//
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // --- find the text view --
//                TextView txtView = (TextView) findViewById(R.id.text_id);
//                // -- change text size --
//                txtView.setTextSize(36);
//            }
//        });
//        btn_del.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // --- find the text view --
//                TextView txtView = (TextView) findViewById(R.id.text_id);
//                // -- change text size --
//                txtView.setTextSize(16);
//            }
//        });
//    }
}
