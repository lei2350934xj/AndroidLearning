package com.example.mysdk;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    /**
     *
     * OkHttpClient 需要在 gradle里面添加依赖 implementation 'com.squareup.okhttp3:okhttp:3.0.1'
     */
    public static String request(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();//发送请求
            return response.body().string();
        } catch (IOException e) {
            System.out.println("http request异常了");
            return "http request false";
        }
    }

    /**
     *  因为网络请求通常都是耗时操作，所以我们必须在这个方法中开启子线程，即执行异步操作
     *  改进方式： https://www.jianshu.com/p/52bc93abc783?utm_source=oschina-app
     *  使用异步请求，回调
     *  建议使用下面的方式来发送http请求
     */
    public static void request(final String url, final Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    // 同步get请求
    public static void getSyn(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient对象
                    OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(50000, TimeUnit.MILLISECONDS)
                            .readTimeout(50000, TimeUnit.MILLISECONDS)
                            .build();;
                    //创建Request
                    Request request = new Request.Builder()
                            .url(url)//访问连接
                            .get()
                            .build();
                    //创建Call对象
                    Call call = client.newCall(request);
                    //通过execute()方法获得请求响应的Response对象
                    Response response = call.execute();
                    if (response.isSuccessful()) {
                        //处理网络请求的响应，处理UI需要在UI线程中处理
                        System.out.println("response.body().string()="+response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String run(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()//基于builder模式新建请求
                .url(url)//传递url 也可以加入 .get() 但默认是get请求
                .build();
        //newCall 是同步请求
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }catch (Exception e){
            //
            return "http request false";
        }
    }
}
