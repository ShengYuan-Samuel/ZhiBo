package com.jiyun.zhibo.ui.live.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.ui.live.adapter.VpAdapter;
import com.jiyun.zhibo.ui.live.fragment.TianZhanFragment;
import com.jiyun.zhibo.ui.live.fragment.ZiYouBoFragment;
import com.jiyun.zhibo.view.NoScrollViewPager;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyLiveActivity extends BaseActivity {


    @BindView(R.id.video_view)
    TXCloudVideoView videoView;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.mylive_camer)
    ImageView myliveCamer;
    @BindView(R.id.my_finish)
    ImageView myFinish;
    @BindView(R.id.live_relativeLayout)
    RelativeLayout liveRelativeLayout;
    @BindView(R.id.mylive_pager)
    NoScrollViewPager mylivePager;
    @BindView(R.id.myLiveTable)
    TabLayout myLiveTable;
    private List<String> mTitie;
    private List<Fragment> mFragment;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_my_live;
    }

    @Override
    protected void init() {
        TXLivePusher mLivePusher = new TXLivePusher(this);
        mLivePusher.startCameraPreview(videoView);
        mTitie = new ArrayList<>();
        mFragment = new ArrayList<>();
        mTitie.add("自由播");
        mTitie.add("挑战");
        mFragment.add(new ZiYouBoFragment());
        mFragment.add(new TianZhanFragment());
        myLiveTable.setupWithViewPager(mylivePager);
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), mTitie, mFragment);
        mylivePager.setAdapter(vpAdapter);



    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.mylive_camer, R.id.my_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mylive_camer:
                break;
            case R.id.my_finish:
                break;
        }
    }
}
