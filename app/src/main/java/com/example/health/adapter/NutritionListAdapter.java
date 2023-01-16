package com.example.health.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.health.R;
import com.example.health.bean.FoodBean;

import java.util.List;

/**
 * @PackageName: com.example.health.adapter
 * @ClassName: NutritionListAdapter
 * @Author: winwa
 * @Date: 2023/1/15 8:44
 * @Description:
 **/
public class NutritionListAdapter extends BaseAdapter {
    Context mContext;
    List<FoodBean> mData;

    public NutritionListAdapter(Context context, List<FoodBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_gridview_nutrition, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        FoodBean foodBean = mData.get(i);
        holder.mPicIv.setImageResource(foodBean.getPicId());
        holder.mTitleTv.setText(foodBean.getTitle());

        return view;
    }

    class ViewHolder {

        private ImageView mPicIv;
        private TextView mTitleTv;

        public ViewHolder(View view) {
            mPicIv = view.findViewById(R.id.gvitem_nutrition_pic_iv);
            mTitleTv = view.findViewById(R.id.gvitem_nutrition_title_tv);
        }
    }
}
