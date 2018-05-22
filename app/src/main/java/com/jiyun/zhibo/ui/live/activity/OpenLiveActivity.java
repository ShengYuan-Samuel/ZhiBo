package com.jiyun.zhibo.ui.live.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.view.GlideCircleTransform;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpenLiveActivity extends BaseActivity {


    @BindView(R.id.open_live_live)
    TXCloudVideoView openLiveLive;
    @BindView(R.id.open_photo)
    ImageView openPhoto;
    @BindView(R.id.open_name)
    TextView openName;
    @BindView(R.id.open_number)
    TextView openNumber;
    @BindView(R.id.open_add)
    ImageView openAdd;
    @BindView(R.id.open_fensihui)
    Button openFensihui;
    @BindView(R.id.open_recycler)
    RecyclerView openRecycler;
    @BindView(R.id.open_finish)
    ImageView openFinish;
    @BindView(R.id.open_room)
    TextView openRoom;
    @BindView(R.id.open_contribute)
    TextView openContribute;
    @BindView(R.id.open_music)
    ImageView openMusic;
    @BindView(R.id.open_xinxi)
    ImageView openXinxi;
    @BindView(R.id.open_gift)
    ImageView openGift;
    @BindView(R.id.open_fanzhuan)
    ImageView openFanzhuan;
    private String url;
    private int liveId;
    private int viewNum;
    private String avatar;
    private String nickName;
    private TXLivePusher mLivePusher;
    private TXLivePushConfig txLivePushConfig;
    private TXLivePlayer mLivePlayer;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_open_live;
    }

    @Override
    protected void init() {
        // TXLivePusher txLivePusher = new TXLivePusher(this);
        //  TXLivePushConfig txLivePushConfig = new TXLivePushConfig();
        // txLivePusher.setConfig(txLivePushConfig);
        //txLivePusher.startCameraPreview(openLiveLive);
        //创建 player 对象
        Intent intent = getIntent();
        String abc = intent.getStringExtra("abc");
        url = intent.getStringExtra("url");
        liveId = intent.getIntExtra("liveId", 0);
        nickName = intent.getStringExtra("nickName");
        viewNum = intent.getIntExtra("viewNum", 0);
        avatar = intent.getStringExtra("avatar");
        if ("拉".equals(abc)) {
            setData();
            openFanzhuan.setVisibility(View.GONE);
            mLivePlayer = new TXLivePlayer(this);
            //关键 player 对象与界面 view
            mLivePlayer.setPlayerView(openLiveLive);
            //String flvUrl = "rtmp://22048.liveplay.myqcloud.com/live/22048_443362640358539264";
            mLivePlayer.startPlay(url, TXLivePlayer.PLAY_TYPE_LIVE_RTMP); //推荐 FLV
        } else {
            openFanzhuan.setVisibility(View.VISIBLE);
            mLivePusher = new TXLivePusher(this);
            txLivePushConfig = new TXLivePushConfig();
            mLivePusher.setConfig(txLivePushConfig);
            mLivePusher.startPusher(url);
            mLivePusher.startCameraPreview(openLiveLive);
        }

        /*
        rtmp://22048.liveplay.myqcloud.com/live/22048_443362640358539264
         */
    }

    @Override
    protected void loadData() {

    }

    private void setData() {
        Glide.with(this).load(avatar).bitmapTransform(new GlideCircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(openPhoto);
        openName.setText(nickName);
        openNumber.setText(viewNum + "人在线");
        openRoom.setText(liveId + "");
    }


    @OnClick({R.id.open_fanzhuan,R.id.open_photo, R.id.open_add, R.id.open_fensihui, R.id.open_finish, R.id.open_music, R.id.open_xinxi, R.id.open_gift})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.open_photo:
                break;
            case R.id.open_add:
                break;
            case R.id.open_fensihui:
                break;
            case R.id.open_finish:
                finish();
                break;
            case R.id.open_music:
                break;
            case R.id.open_xinxi:
                break;
            case R.id.open_gift:
                break;
            case R.id.open_fanzhuan:
                txLivePushConfig.setFrontCamera(false);
                mLivePusher.switchCamera();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLivePlayer != null){
        mLivePlayer.stopPlay(true); // true 代表清除最后一帧画面
        openLiveLive.onDestroy();
        }
    }
}
