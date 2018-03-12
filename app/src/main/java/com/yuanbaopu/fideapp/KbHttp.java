package com.yuanbaopu.fideapp;


import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.FormBody;
import okhttp3.Call;

public class KbHttp {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        System.out.println(121212);
        RequestBody body = new FormBody.Builder()
                .add("login", "18055417483")
                .add("pass", "07809709").build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response);
        return  response.body().string();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(1212121212);
        KbHttp example = new KbHttp();
        String response = example.run("https://fidebszltest.yuanbaopu.com/api/");
        System.out.println(response);
    }
}
