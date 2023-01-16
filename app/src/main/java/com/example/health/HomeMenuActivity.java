package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.home_menu1_btn:
                intent.setClass(HomeMenuActivity.this, MatchListActivity.class);
                break;
            case R.id.home_menu2_btn:
                intent.setClass(HomeMenuActivity.this, NutritionActivity.class);
                break;
            case R.id.home_menu3_btn:
                intent.setClass(HomeMenuActivity.this, AboutActivity.class);
                break;
        }
        startActivity(intent);
    }
}