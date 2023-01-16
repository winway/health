package com.example.health;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.health.adapter.GuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mGuideVp;
    private TextView mNumTv1, mNumTv2, mNumTv3;
    private Button mGuideBtn;

    private List<View> mViewList;
    private List<TextView> mNumViewList;
    private int mPicResId[] = {R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3};
    private GuidePagerAdapter mGuidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mGuideVp = findViewById(R.id.guide_vp);
        mNumTv1 = findViewById(R.id.guide_number_1_tv);
        mNumTv2 = findViewById(R.id.guide_number_2_tv);
        mNumTv3 = findViewById(R.id.guide_number_3_tv);
        mGuideBtn = findViewById(R.id.guide_btn);

        mViewList = new ArrayList<>();
        mNumViewList = new ArrayList<>();

        for (int i = 0; i < mPicResId.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_viewpager_guide, null);
            view.setBackgroundResource(mPicResId[i]);
            mViewList.add(view);
        }

        mNumViewList.add(mNumTv1);
        mNumViewList.add(mNumTv2);
        mNumViewList.add(mNumTv3);

        mGuidePagerAdapter = new GuidePagerAdapter(mViewList);
        mGuideVp.setAdapter(mGuidePagerAdapter);

        mNumTv1.setTextColor(Color.RED);

        mGuideVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mPicResId.length; i++) {
                    mNumViewList.get(i).setTextColor(Color.WHITE);
                }
                mNumViewList.get(position).setTextColor(Color.RED);
                if (position == 2) {
                    mGuideBtn.setVisibility(View.VISIBLE);
                } else {
                    mGuideBtn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mGuideBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.guide_btn:
                Intent intent = new Intent(GuideActivity.this, HomeMenuActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}