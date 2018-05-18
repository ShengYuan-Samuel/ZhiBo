package com.jiyun.zhibo.ui.live.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseFragment;
import com.jiyun.zhibo.model.entify.TianZhanBean;

import java.util.ArrayList;
import java.util.List;


public class TianZhanFragment extends BaseFragment {

    private List<TianZhanBean> mList;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tian_zhan;
    }

    @Override
    protected void init() {
        mList = new ArrayList<>();
        mList.add(new TianZhanBean(R.drawable.icon_challenge_type_singe,"唱歌","展示天籁之音，做认证主播"));
        mList.add(new TianZhanBean(R.drawable.icon_challenge_type_rap,"Rap","用嘻哈诉说你的故事"));
        mList.add(new TianZhanBean(R.drawable.icon_challenge_type_dance,"跳舞","挑一挑，十年少"));

        mList.add(new TianZhanBean(R.drawable.icon_challenge_type_singe,"乐器","展示天籁之音，做认证主播"));
        mList.add(new TianZhanBean(R.drawable.icon_challenge_type_singe,"表演","展示天籁之音，做认证主播"));
        mList.add(new TianZhanBean(R.drawable.icon_challenge_type_singe,"口才","展示天籁之音，做认证主播"));

    }

    @Override
    protected void loadData() {

    }
}
