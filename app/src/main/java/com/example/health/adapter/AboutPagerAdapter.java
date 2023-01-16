package com.example.health.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @PackageName: com.example.health.adapter
 * @ClassName: AboutPagerAdapter
 * @Author: winwa
 * @Date: 2023/1/15 17:24
 * @Description:
 **/
public class AboutPagerAdapter extends PagerAdapter {
    private static final String TAG = "AboutPagerAdapter";

    List<View> mViewList;

    public AboutPagerAdapter(List<View> viewList) {
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.i(TAG, "instantiateItem: " + position);
        View view = mViewList.get(position % mViewList.size());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = mViewList.get(position % mViewList.size());
        container.removeView(view);
    }
}
