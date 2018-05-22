package com.jiyun.zhibo.ui.live.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseFragment;
import com.jiyun.zhibo.contract.LiveContract;
import com.jiyun.zhibo.model.entify.LunBoBeans;
import com.jiyun.zhibo.model.entify.RenQiBean;
import com.jiyun.zhibo.presenter.LivePresenter;
import com.jiyun.zhibo.ui.live.activity.OpenLiveActivity;
import com.jiyun.zhibo.ui.live.adapter.RenQiAdapter;
import com.jiyun.zhibo.ui.live.adapter.TuiJianAdapter;
import com.jiyun.zhibo.view.SpaceItemDecoration;
import com.recker.flybanner.FlyBanner;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LiveFragment extends BaseFragment<LivePresenter> implements LiveContract.View {


    @BindView(R.id.live_search)
    LinearLayout liveSearch;
    @BindView(R.id.live_news)
    ImageView liveNews;
    @BindView(R.id.live_smartRefresh)
    SmartRefreshLayout liveSmartRefresh;
    @BindView(R.id.banner)
    FlyBanner banner;
    @BindView(R.id.live_tianzhan_relative)
    RelativeLayout liveTianzhanRelative;
    @BindView(R.id.renqi_recycler)
    RecyclerView renqiRecycler;
    @BindView(R.id.wenming_image)
    ImageView wenmingImage;
    @BindView(R.id.tiaozhan_recycler)
    RecyclerView tiaozhanRecycler;
    private List<RenQiBean.DataBean.ListBean> mRenqi;
    private List<RenQiBean.DataBean.ListBean> mTuiJian;
    private RenQiAdapter renQiAdapter;
    private TuiJianAdapter tuiJianAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void init() {
        mRenqi = new ArrayList<>();
        mTuiJian = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        tiaozhanRecycler.setLayoutManager(gridLayoutManager);
        renqiRecycler.setLayoutManager(linearLayoutManager);
        renQiAdapter = new RenQiAdapter(R.layout.renqi_view_view, mRenqi);
        tuiJianAdapter = new TuiJianAdapter(R.layout.tuijian_view_view, mTuiJian);
        tiaozhanRecycler.addItemDecoration(new SpaceItemDecoration(10,5));
        renqiRecycler.setAdapter(renQiAdapter);
        tiaozhanRecycler.setAdapter(tuiJianAdapter);
        renQiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), OpenLiveActivity.class);
                intent.putExtra("abc","拉");
                intent.putExtra("nickName",mRenqi.get(position).getNickName());
                intent.putExtra("url",mRenqi.get(position).getRtmpPullUrl());
                intent.putExtra("liveId",mRenqi.get(position).getLiveId());
                intent.putExtra("viewNum",mRenqi.get(position).getViewNum());
                intent.putExtra("avatar",mRenqi.get(position).getAvatar());
                startActivity(intent);
            }
        });
        tuiJianAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), OpenLiveActivity.class);
                intent.putExtra("abc","拉");
                intent.putExtra("nickName",mRenqi.get(position).getNickName());
                intent.putExtra("url",mRenqi.get(position).getRtmpPullUrl());
                intent.putExtra("liveId",mRenqi.get(position).getLiveId());
                intent.putExtra("viewNum",mRenqi.get(position).getViewNum());
                intent.putExtra("avatar",mRenqi.get(position).getAvatar());
                startActivity(intent);
            }
        });
        liveSmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mRenqi.clear();
                mTuiJian.clear();
                presenter.getRenQiData();
                presenter.getTuiJianData();
            }
        });

    }

    @Override
    protected void loadData() {
        presenter.getLunBoBeans();
        presenter.getRenQiData();
        presenter.getTuiJianData();

    }

    @Override
    public void showLunBoBean(LunBoBeans lunBoBeans) {
        if (lunBoBeans == null)
            return;
        List<String> mList = new ArrayList<>();
        for (LunBoBeans.DataBeanX.DataBean.ListBean listBean : lunBoBeans.getData().getData().getList()) {
            mList.add(listBean.getAdPic());
        }
        banner.setImagesUrl(mList);
        banner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "点击了第" + position + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(this).load(mList.get(2)).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(wenmingImage);


    }

    @Override
    public void showRenQiData(RenQiBean renQiBean) {

        if (renQiBean == null)
            return;
        liveSmartRefresh.finishRefresh();
        mRenqi.addAll(renQiBean.getData().getList());
        renQiAdapter.notifyDataSetChanged();
        Log.d("LiveFragment", "renQiBean.getData().getList().size():" + renQiBean.getData().getList().size());
    }

    @Override
    public void showTuiJianData(RenQiBean renQiBean) {
        if (renQiBean == null)
            return;
        liveSmartRefresh.finishRefresh();
        mTuiJian.addAll(renQiBean.getData().getList());
        tuiJianAdapter.notifyDataSetChanged();

    }


    @OnClick({R.id.live_search, R.id.live_news, R.id.live_smartRefresh,R.id.live_tianzhan_relative, R.id.wenming_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.live_search:
                Toast.makeText(getContext(), "我去搜索了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.live_news:
                Toast.makeText(getContext(), "我去消息了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.live_tianzhan_relative:
                break;
            case R.id.wenming_image:
                break;

        }
    }
}
