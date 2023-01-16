package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.health.adapter.NutritionListAdapter;
import com.example.health.bean.FoodBean;
import com.example.health.utils.FoodUtils;

import java.util.List;

public class NutritionActivity extends AppCompatActivity {

    private GridView mNutritionGridView;
    private List<FoodBean> mData;
    private NutritionListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        mNutritionGridView = findViewById(R.id.nutrition_gv);

        mData = FoodUtils.getAllFoodList();
        mAdapter = new NutritionListAdapter(this, mData);
        mNutritionGridView.setAdapter(mAdapter);

        initListener();
    }

    private void initListener() {
        mNutritionGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodBean foodBean = mData.get(i);
                Intent intent = new Intent(NutritionActivity.this, DetailActivity.class);
                intent.putExtra("food", foodBean);
                startActivity(intent);
            }
        });
    }
}