package com.jiyun.zhibo.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.ui.broadcasting.fragment.BroadCastingFragment;
import com.jiyun.zhibo.ui.find.fragment.FindFragment;
import com.jiyun.zhibo.ui.live.activity.MyLiveActivity;
import com.jiyun.zhibo.ui.live.fragment.LiveFragment;
import com.jiyun.zhibo.ui.my.fragment.MyFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.live_rb)
    RadioButton liveRb;
    @BindView(R.id.broadcasting_rb)
    RadioButton broadcastingRb;
    @BindView(R.id.broadcast_rb)
    ImageView broadcastRb;
    @BindView(R.id.find_rb)
    RadioButton findRb;
    @BindView(R.id.my_rb)
    RadioButton myRb;


    @Override
    protected int getLayOutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        setContentView(R.id.fl_content, LiveFragment.class);
        liveRb.setChecked(true);

    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.live_rb, R.id.broadcasting_rb, R.id.broadcast_rb, R.id.find_rb, R.id.my_rb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.live_rb:
                setContentView(R.id.fl_content, LiveFragment.class);

                break;
            case R.id.broadcasting_rb:
                setContentView(R.id.fl_content, BroadCastingFragment.class);
                break;
            case R.id.broadcast_rb:
                startActivity(new Intent(this, MyLiveActivity.class));
                break;
            case R.id.find_rb:
                setContentView(R.id.fl_content, FindFragment.class);
                break;
            case R.id.my_rb:
                setContentView(R.id.fl_content, MyFragment.class);
                break;
        }
    }
}
