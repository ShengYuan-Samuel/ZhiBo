package com.jiyun.zhibo.ui.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseFragment;
import com.jiyun.zhibo.ui.HomeActivity;
import com.jiyun.zhibo.ui.login.activity.LoginActivity;
import com.jiyun.zhibo.ui.register.RegisterPswActivity;
import com.jiyun.zhibo.utils.SavaShareUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 这是直播页面
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.personage_seeting)
    ImageView personageSeeting;
    @BindView(R.id.mind_userphoto)
    ImageView mindUserphoto;
    @BindView(R.id.mind_userName)
    TextView mindUserName;
    @BindView(R.id.mind_userDjImg)
    ImageView mindUserDjImg;
    @BindView(R.id.personage_relativelayout)
    RelativeLayout personageRelativelayout;
    @BindView(R.id.personage_focus_numTv)
    TextView personageFocusNumTv;
    @BindView(R.id.personage_focus_layout)
    LinearLayout personageFocusLayout;
    @BindView(R.id.personage_fans_numTv)
    TextView personageFansNumTv;
    @BindView(R.id.personage_fans_layout)
    LinearLayout personageFansLayout;
    @BindView(R.id.mind_userChat)
    LinearLayout mindUserChat;
    @BindView(R.id.mind_userPrivilege)
    LinearLayout mindUserPrivilege;
    @BindView(R.id.mind_userWallet)
    LinearLayout mindUserWallet;
    @BindView(R.id.mind_userHelper)
    LinearLayout mindUserHelper;
    @BindView(R.id.mind_userFans)
    LinearLayout mindUserFans;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void init() {


    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onResume() {
        super.onResume();
        if (SavaShareUtils.getInstance().getUserNo() == null){

        }else{
        }
    }

    @OnClick({R.id.personage_seeting, R.id.personage_relativelayout, R.id.personage_focus_layout, R.id.personage_fans_layout, R.id.mind_userChat, R.id.mind_userPrivilege, R.id.mind_userWallet, R.id.mind_userHelper, R.id.mind_userFans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personage_seeting:
                break;
            case R.id.personage_relativelayout:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.personage_focus_layout:
                break;
            case R.id.personage_fans_layout:
                break;
            case R.id.mind_userChat:
                break;
            case R.id.mind_userPrivilege:
                break;
            case R.id.mind_userWallet:
                break;
            case R.id.mind_userHelper:
                break;
            case R.id.mind_userFans:
                break;
        }
    }


}
