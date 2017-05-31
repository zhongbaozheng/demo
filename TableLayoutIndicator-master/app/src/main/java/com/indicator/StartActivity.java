package com.indicator;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/25.
 */

public class StartActivity extends AppCompatActivity {


    private String[] mTitles = {"Home","Mine"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private NoScrollViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initViews();
        addFragments();
        setmViewPager();
    }

    private void setmViewPager(){

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(tabAdapter);
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));//设置文本在选中和为选中时候的颜色
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void addFragments(){
        mFragments.add(new MainFragment());
        mFragments.add(MineFragment.newInstance(1));
    }

    private void initViews(){
        mViewPager = (NoScrollViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.table);
    }


}
