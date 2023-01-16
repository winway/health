package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.health.bean.FoodBean;

public class DetailActivity extends AppCompatActivity {
    private ImageView mBackIv;
    private TextView mTitleTv;
    private ImageView mPicIv;
    private TextView mDescTitleTv;
    private TextView mContentTv;
    private TextView mConflictTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        Intent intent = getIntent();
        FoodBean food = (FoodBean) intent.getSerializableExtra("food");
        mTitleTv.setText(food.getTitle());
        mPicIv.setImageResource(food.getPicId());
        mDescTitleTv.setText(food.getTitle());
        mContentTv.setText(food.getDesc());
        mConflictTv.setText(food.getConflict());
    }

    private void initView() {
        mBackIv = findViewById(R.id.detail_back_iv);
        mTitleTv = findViewById(R.id.detail_title_tv);
        mPicIv = findViewById(R.id.detail_pic_iv);
        mDescTitleTv = findViewById(R.id.detail_desc_title_tv);
        mContentTv = findViewById(R.id.detail_content_tv);
        mConflictTv = findViewById(R.id.detail_conflict_tv);

        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}