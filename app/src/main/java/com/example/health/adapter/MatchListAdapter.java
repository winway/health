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
 * @ClassName: MatchListAdapter
 * @Author: winwa
 * @Date: 2023/1/14 21:09
 * @Description:
 **/
public class MatchListAdapter extends BaseAdapter {
    Context mContext;
    List<FoodBean> mData;

    public MatchListAdapter(Context context, List<FoodBean> data) {
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_listview_match, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        FoodBean foodBean = mData.get(i);
        holder.mPicIv.setImageResource(foodBean.getPicId());
        holder.mTitleTv.setText(foodBean.getTitle());
        holder.mConflictTv.setText(foodBean.getConflict());

        return view;
    }

    class ViewHolder {

        private ImageView mPicIv;
        private TextView mTitleTv;
        private TextView mConflictTv;

        public ViewHolder(View view) {
            mPicIv = view.findViewById(R.id.lvitem_match_pic_iv);
            mTitleTv = view.findViewById(R.id.lvitem_match_title_tv);
            mConflictTv = view.findViewById(R.id.lvitem_match_conflict_tv);
        }
    }
}
