package com.example.health.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @PackageName: com.example.health.adapter
 * @ClassName: GuidePagerAdapter
 * @Author: winwa
 * @Date: 2023/1/16 8:28
 * @Description:
 **/
public class GuidePagerAdapter extends PagerAdapter {
    private List<View> mViewList;

    public GuidePagerAdapter(List<View> viewList) {
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mViewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = mViewList.get(position);
        container.removeView(view);
    }
}
