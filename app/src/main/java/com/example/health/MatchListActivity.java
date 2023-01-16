package com.example.health;

import static com.example.health.utils.FoodUtils.getAllFoodList;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.health.adapter.MatchListAdapter;
import com.example.health.bean.FoodBean;

import java.util.ArrayList;
import java.util.List;

public class MatchListActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mSearchEt;
    private ImageView mSearchIv;
    private ImageView mResetIv;
    private ListView mMatchLv;

    private List<FoodBean> mData;
    private List<FoodBean> mFoodDataSource;
    private MatchListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);

        initView();

        mData = new ArrayList<>();
        mFoodDataSource = getAllFoodList();
        mData.addAll(mFoodDataSource);

        mAdapter = new MatchListAdapter(MatchListActivity.this, mData);
        mMatchLv.setAdapter(mAdapter);

        initListener();
    }

    private void initListener() {
        mMatchLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodBean foodBean = mData.get(i);
                Intent intent = new Intent(MatchListActivity.this, DetailActivity.class);
                intent.putExtra("food", foodBean);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mSearchEt = findViewById(R.id.match_search_et);
        mSearchIv = findViewById(R.id.match_search_iv);
        mResetIv = findViewById(R.id.match_reset_iv);
        mMatchLv = findViewById(R.id.match_lv);

        mSearchIv.setOnClickListener(this);
        mResetIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.match_search_iv:
                String input = mSearchEt.getText().toString().trim();
                if (TextUtils.isEmpty(input)) {
                    Toast.makeText(this, "输入为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<FoodBean> filteredList = new ArrayList<>();
                for (int i = 0; i < mFoodDataSource.size(); i++) {
                    if (mFoodDataSource.get(i).getTitle().contains(input)) {
                        filteredList.add(mFoodDataSource.get(i));
                    }
                }
                mData.clear();
                mData.addAll(filteredList);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.match_reset_iv:
                mData.clear();
                mData.addAll(mFoodDataSource);
                mAdapter.notifyDataSetChanged();
                break;
        }
    }
}