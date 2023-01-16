package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.health.adapter.AboutPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AboutActivity";

    private static final int MSG_AUTO_PLAY = 1;

    private ViewPager mBannerVp;
    private LinearLayout mBannerPointLl;
    private TextView mShareTv;

    private List<View> mViewList;
    private int[] picIds = {R.mipmap.ab1, R.mipmap.ab2, R.mipmap.ab3, R.mipmap.ab4, R.mipmap.ab5};

    private AboutPagerAdapter mAboutPagerAdapter;

    private List<ImageView> mBannerPointList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mBannerVp = findViewById(R.id.about_banner_vp);
        mBannerPointLl = findViewById(R.id.about_banner_point_ll);
        mShareTv = findViewById(R.id.about_share_tv);

        mShareTv.setOnClickListener(this);

        mViewList = new ArrayList<>();
        mBannerPointList = new ArrayList<>();
        for (int i = 0; i < picIds.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_viewpager_about, null);
            ImageView vpItem = view.findViewById(R.id.vpitem_about_pic_iv);
            vpItem.setImageResource(picIds[i]);
            mViewList.add(view);

            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 20, 0);
            point.setLayoutParams(params);
            point.setImageResource(R.mipmap.a2);
            mBannerPointList.add(point);
            mBannerPointLl.addView(point);
        }
        mBannerPointList.get(0).setImageResource(R.mipmap.a3);

        mAboutPagerAdapter = new AboutPagerAdapter(mViewList);
        mBannerVp.setAdapter(mAboutPagerAdapter);
        setBannerVpListener();

        mHandler.sendEmptyMessageDelayed(MSG_AUTO_PLAY, 5000);
    }

    private void setBannerVpListener() {
        mBannerVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: " + position);
                for (int i = 0; i < mBannerPointList.size(); i++) {
                    if (i == position % mBannerPointList.size()) {
                        mBannerPointList.get(i).setImageResource(R.mipmap.a3);
                    } else {
                        mBannerPointList.get(i).setImageResource(R.mipmap.a2);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg = "快来下载APP~";
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(intent, "健康饮食分享"));
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == MSG_AUTO_PLAY) {
                int currentPos = mBannerVp.getCurrentItem();
                mBannerVp.setCurrentItem(currentPos + 1);
                mHandler.sendEmptyMessageDelayed(MSG_AUTO_PLAY, 5000);
            }
        }
    };
}