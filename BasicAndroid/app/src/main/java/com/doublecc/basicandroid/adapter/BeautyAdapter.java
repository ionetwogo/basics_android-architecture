package com.doublecc.basicandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.widget.ResizableImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<BeanBeauty> mBeautyList;

    public BeautyAdapter(Context mContext,List<BeanBeauty> mBeautyList) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.mBeautyList = mBeautyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_beauty,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mBeautyList.get(position).url).into(holder.mImgBeauty);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeautyList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_photo)
        ResizableImageView mImgBeauty;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
