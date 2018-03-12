package com.yuanbaopu.fideapp;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view){
                attemptLogin();
            }
        });

    }


    //登录
    public void attemptLogin()  {

        new Thread(networkTask).start();
    }


    Runnable networkTask = new Runnable() {
        KbHttp http = new KbHttp();
        @Override
        public void run() {
//            https://fidebszltest.yuanbaopu.com/api/
            try{
                http.run("https://fidebszltest.yuanbaopu.com/api/");
            }catch (Exception e) {
                e.printStackTrace();
            };
        }
    };
}

