package com.example.health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int MSG_COUNTDOWN = 0;

    private TextView mSplashTv;

    private int time = 5;
    private boolean mIsFirst;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == MSG_COUNTDOWN) {
                time--;
                if (time == 0) {
                    Intent intent = new Intent();
                    if (mIsFirst) {
                        intent.setClass(SplashActivity.this, GuideActivity.class);
                        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                        editor.putBoolean("is_first", false);
                        editor.apply();
                    } else {
                        intent.setClass(SplashActivity.this, HomeMenuActivity.class);
                    }
                    startActivity(intent);
                    finish();
                } else {
                    mSplashTv.setText(time + "");
                    mHandler.sendEmptyMessageDelayed(MSG_COUNTDOWN, 1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashTv = findViewById(R.id.splash_tv);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        mIsFirst = preferences.getBoolean("is_first", true);

        mHandler.sendEmptyMessageDelayed(MSG_COUNTDOWN, 1000);
    }
}