package com.jiyun.zhibo.ui.live.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseFragment;
import com.jiyun.zhibo.view.RoundImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ZiYouBoFragment extends BaseFragment {


    @BindView(R.id.ziyoubo_photo)
    RoundImageView ziyouboPhoto;
    @BindView(R.id.ziyoubo_contentEt)
    EditText ziyouboContentEt;
    @BindView(R.id.ziyoubo_wechat)
    ImageView ziyouboWechat;
    @BindView(R.id.ziyoubo_weibo)
    ImageView ziyouboWeibo;
    @BindView(R.id.ziyoubo_wechat_friend)
    ImageView ziyouboWechatFriend;
    @BindView(R.id.ziyoubo_meiYan)
    LinearLayout ziyouboMeiYan;
    @BindView(R.id.ziyoubo_startBtu)
    Button ziyouboStartBtu;
    @BindView(R.id.ziyoubo_xieyiTv)
    TextView ziyouboXieyiTv;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zi_you_bo;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.ziyoubo_photo, R.id.ziyoubo_wechat, R.id.ziyoubo_weibo, R.id.ziyoubo_wechat_friend, R.id.ziyoubo_meiYan, R.id.ziyoubo_startBtu, R.id.ziyoubo_xieyiTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ziyoubo_photo:
                Toast.makeText(getContext(), "我去选择照片了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_wechat:
                Toast.makeText(getContext(), "我去微信了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_weibo:
                Toast.makeText(getContext(), "我去微博了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_wechat_friend:
                Toast.makeText(getContext(), "我去朋友圈了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_meiYan:
                Toast.makeText(getContext(), "我去美颜了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_startBtu:
                Toast.makeText(getContext(), "我要开始直播了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_xieyiTv:
                Toast.makeText(getContext(), "我去协议了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
