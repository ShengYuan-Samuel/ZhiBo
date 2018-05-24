package com.jiyun.zhibo.ui.live.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.model.entify.GiftBean;

import java.util.List;

public class GiftGridAdapter extends BaseAdapter {
    private Context context;
    private List<GiftBean.DataBean.ListBean> mList;
    /**
     * 每一页显示的个数
     */
    public GiftGridAdapter(Context context, List<GiftBean.DataBean.ListBean> mList) {
        this.context = context;
        this.mList = mList;

    }

    @Override
    public int getCount() {
        return mList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return 0;

    }

    @Override
    public long getItemId(int position) {
        return 0 ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.gift_grid_view_view, parent,false);
            holder.iv_gift_img = (ImageView) convertView.findViewById(R.id.iv_gift_img);
            holder.tv_gift_name = (TextView) convertView.findViewById(R.id.tv_gift_name);
            holder.tv_gift_money = (TextView) convertView.findViewById(R.id.tv_gift_money);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(mList.get(position).getGiftPic()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.iv_gift_img);
        holder.tv_gift_money.setText(mList.get(position).getGiftPrice()+"");
        holder.tv_gift_name.setText(mList.get(position).getGiftName());
        return convertView;
    }
    class ViewHolder {
        public ImageView iv_gift_img;
        public TextView tv_gift_name;
        public TextView tv_gift_money;



    }
}
