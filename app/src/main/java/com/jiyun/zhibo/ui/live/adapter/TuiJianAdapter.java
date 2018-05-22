package com.jiyun.zhibo.ui.live.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.model.entify.RenQiBean;

import java.util.List;

public class TuiJianAdapter extends BaseQuickAdapter<RenQiBean.DataBean.ListBean,BaseViewHolder> {
    public TuiJianAdapter(int layoutResId, @Nullable List<RenQiBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RenQiBean.DataBean.ListBean item) {
        Glide.with(mContext).load(item.getCover()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into((ImageView) helper.getView(R.id.tuijian_view_image));
        helper.setText(R.id.tuijian_view_tv,item.getName());
    }
}
