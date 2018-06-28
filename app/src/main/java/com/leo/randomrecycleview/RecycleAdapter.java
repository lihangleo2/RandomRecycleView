package com.leo.randomrecycleview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by lihang on 2016/4/18.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<String> faceList;
    private Context context;
    private View.OnClickListener onClickListener;

    public RecycleAdapter(Context context,View.OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public void setData(ArrayList<String> faceList) {
        this.faceList = faceList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recy, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.text_item.setText("我是item" + position);

        myViewHolder.text_item.setTag(position);
        myViewHolder.text_item.setOnClickListener(onClickListener);
    }


    @Override
    public int getItemCount() {
        return faceList == null ? 0 : faceList.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_item = itemView.findViewById(R.id.text_item);
        }
    }


}
