package com.jiyun.zhibo.ui.live.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
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
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption;
    private TXLivePushConfig mLivePushConfig;
    private TXLivePusher mLivePusher;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_my_live;
    }

    @Override
    protected void init() {
        initGaoDe();

        mLivePusher = new TXLivePusher(this);
        mLivePushConfig = new TXLivePushConfig();
        mLivePusher.setConfig(mLivePushConfig);
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
                Log.d("MyLiveActivity", "w欧本点击了");
                mLivePushConfig.setFrontCamera(false);
                mLivePusher.switchCamera();
                break;
            case R.id.my_finish:
                break;
        }
    }
    private void initGaoDe(){
        //初始化定位
        mLocationClient = new AMapLocationClient(this);
        ///初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        /**
         * 设置定位场景，目前支持三种场景（签到、出行、运动，默认无场景）
         */
        mLocationOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if(null != mLocationClient){
            mLocationClient.setLocationOption(mLocationOption);
            //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(1000);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否允许模拟位置,默认为true，允许模拟位置
        mLocationOption.setMockEnable(true);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        String city = aMapLocation.getCity();//城市信息
                        address.setText(city);
                        Log.d("MyLiveActivity", city);
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError","location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        };
        mLocationClient.setLocationListener(mLocationListener);
        mLocationClient.startLocation();
    }
}
