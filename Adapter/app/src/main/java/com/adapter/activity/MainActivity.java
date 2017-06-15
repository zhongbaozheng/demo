package com.adapter.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.adapter.R;
import com.adapter.adapter.BaseRecycleAdapter;
import com.adapter.adapter.BaseRecycleHolder;
import com.adapter.untils.DividerItemDecoration;
import com.adapter.untils.SpaceItemDecoration;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/15.
 */

public class MainActivity extends AppCompatActivity implements BaseRecycleAdapter.ItemClickListener{

    private ArrayList<MyBean> mList = new ArrayList<>();
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setListData();
        myAdapter = new MyAdapter(this,mList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.addItemDecoration(new SpaceItemDecoration(20));
        myAdapter.notifyDataSetChanged();
        myAdapter.setOnItemClickListner(this);
//        myAdapter.setOnItemClickListner(new BaseRecycleAdapter.ItemClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
//
//            }
//        });
    }

    private void setListData(){
        for(int i =0;i<25;i++){
            MyBean bean = new MyBean();
            bean.text = "FirstType   "+i;
            bean.type = 0;
            if( i%2 == 0){
                bean.type = 1;
                bean.text = "SecondType   "+i;
            }
            mList.add(bean);
        }
    }

    @Override
    public void OnItemClick(View view, int position) {
        Toast.makeText(this,"Item    "+position,Toast.LENGTH_SHORT).show();
    }
}
