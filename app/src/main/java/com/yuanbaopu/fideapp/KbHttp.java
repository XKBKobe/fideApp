package com.yuanbaopu.fideapp;


import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.FormBody;

public class KbHttp {
    OkHttpClient client = new OkHttpClient();

    String Post(String url) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add("loginName", "18055417483")
                .add("password", "18055417483")
                .add("sysSource", "2").build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        System.out.println(response);
        return  response.body().string();
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(1212121212);
//        KbHttp example = new KbHttp();
//        String response = example.run("https://fidebsz.yuanbaopu.com/api/");
//        System.out.println(response);
    }
}
