package com.jiyun.zhibo.ui.my.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.model.entify.MoneyDataBean;

import java.util.List;

public class MoneyAdapter extends BaseQuickAdapter<MoneyDataBean.DataBean.ListBean,BaseViewHolder>{
    public MoneyAdapter(int layoutResId, @Nullable List<MoneyDataBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MoneyDataBean.DataBean.ListBean item) {
        helper.setBackgroundRes(R.id.pay_view_view_linear,R.drawable.pay_shape);
        helper.setText(R.id.pay_yibi,item.getVc()+"艺币");
        helper.setText(R.id.pay_money,(item.getPrice()/100.0)+"元");
        helper.addOnClickListener(R.id.pay_view_view_linear);

    }
}
