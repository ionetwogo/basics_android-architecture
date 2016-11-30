package com.doublecc.basicandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.bean.BeanBeauty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class TechnologyItemAdapter extends RecyclerView.Adapter<TechnologyItemAdapter.Viewholder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<BeanBeauty> mList;

    public TechnologyItemAdapter(Context mContext,List<BeanBeauty> list) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.mList = list;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_technology,parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.mTvType.setText(mList.get(position).type);
        holder.mTvTitle.setText(mList.get(position).desc);
        holder.mTvAuthor.setText(mList.get(position).who);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_type)
        TextView mTvType;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_author)
        TextView mTvAuthor;

        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
