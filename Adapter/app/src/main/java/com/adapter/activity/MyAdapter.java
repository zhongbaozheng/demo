package com.adapter.activity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.adapter.R;
import com.adapter.adapter.BaseRecycleAdapter;
import com.adapter.adapter.BaseRecycleHolder;
import com.adapter.adapter.CommonAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/15.
 */

public  class MyAdapter extends CommonAdapter<MyBean>  {

    private ArrayList<MyBean> myBeanArrayList = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<MyBean> list){
        super(context,list);
        myBeanArrayList = list;
    }


    @Override
    public void instanceOfViewHolder(BaseRecycleHolder holder, MyBean myBean, int position) {
        holder.setText(R.id.list_item,myBean.text);
    }

    //first type
    @Override
    public int getItemLayoutId() {
        return R.layout.re_item;
    }

    //second type
    @Override
    public int getItemOtherLayoutId() {
        return R.layout.re_item2;
    }

    @Override
    public int getItemViewType(int position) {
        if(myBeanArrayList.get(position).type == 1){
            return 1;
        }else if(myBeanArrayList.get(position).type == 0) {
            return 0;
        }else{
            //if none,then set default
            return super.getItemViewType(position);
        }
    }
}
