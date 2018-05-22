package com.jiyun.zhibo.ui.live.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.model.entify.ImageBean;

import java.util.List;

public class ZiYouAdapter extends RecyclerView.Adapter<ZiYouAdapter.ViewHolder> implements View.OnClickListener {
    private List<ImageBean> mList;

    public ZiYouAdapter(List<ImageBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.meiyan_view,parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        inflate.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageSelect.setImageResource(mList.get(position).getSelectPhoto());
        holder.image.setImageResource(mList.get(position).getPhoto());
       /* if (position == 0){
            holder.image.setVisibility(View.VISIBLE);
            holder.imageSelect.setVisibility(View.VISIBLE);
        }*/
        holder.imageSelect.setOnClickListener(this);
        holder.imageSelect.setTag(position);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if (photoOnClickCallBack!=null){
            photoOnClickCallBack.setOnCilck(v,(int)v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private ImageView imageSelect;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.meiyan_tu_image);
            imageSelect = itemView.findViewById(R.id.select_image);
        }
    }

    private PhotoOnClickCallBack photoOnClickCallBack;

    public interface PhotoOnClickCallBack{
        void setOnCilck(View view,int position);
    }

    public void setOnClick(PhotoOnClickCallBack photoOnClickCallBack){
        this.photoOnClickCallBack = photoOnClickCallBack;

    }

}
