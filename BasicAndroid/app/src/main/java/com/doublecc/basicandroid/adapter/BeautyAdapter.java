package com.doublecc.basicandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.module.beauty.PhotoViewActivity;
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Glide.with(mContext).load(mBeautyList.get(position).url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.mImgBeauty);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoViewActivity.class);
                intent.putExtra(PhotoViewActivity.PHOTO_URL,mBeautyList.get(position).url);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext,holder.mImgBeauty,PhotoViewActivity.TRANSIT_PHOTO);
                // 这种切换效果有版本要求
                try{
                    ActivityCompat.startActivity(mContext,intent,optionsCompat.toBundle());
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                    mContext.startActivity(intent);
                }
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
