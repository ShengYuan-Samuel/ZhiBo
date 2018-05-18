package com.jiyun.zhibo.ui.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseFragment;
import com.jiyun.zhibo.contract.MyLoginContract;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.presenter.MyLoginPresenter;
import com.jiyun.zhibo.ui.HomeActivity;
import com.jiyun.zhibo.ui.login.activity.LoginActivity;
import com.jiyun.zhibo.ui.register.RegisterPswActivity;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.view.GlideCircleTransform;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 这是直播页面
 */
public class MyFragment extends BaseFragment<MyLoginPresenter> implements MyLoginContract.View {


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
        if (SavaShareUtils.getInstance().getUserNo() != null){
            presenter.getUserInFoData();
        }
    }

    @OnClick({R.id.personage_seeting, R.id.personage_relativelayout, R.id.personage_focus_layout, R.id.personage_fans_layout, R.id.mind_userChat, R.id.mind_userPrivilege, R.id.mind_userWallet, R.id.mind_userHelper, R.id.mind_userFans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personage_seeting:
                break;
            case R.id.personage_relativelayout:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }
                break;
            case R.id.personage_focus_layout:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }
                break;
            case R.id.personage_fans_layout:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }
                break;
            case R.id.mind_userChat:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }
                break;
            case R.id.mind_userPrivilege:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }
                break;
            case R.id.mind_userWallet:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }
                break;
            case R.id.mind_userHelper:
                if (SavaShareUtils.getInstance().getUserNo() == null){
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }else{
                    Log.d("MyFragment", "我跳转了");
                }


                break;
            case R.id.mind_userFans:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                    Toast.makeText(getContext(), getTime(date), Toast.LENGTH_SHORT).show();
                    }
                }).build();
                pvTime.show();
                break;
        }
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    @Override
    public void showUserInFo(LoginBean loginBean) {
        if (loginBean==null)
            return;
        if (Integer.valueOf(loginBean.getCode())== 200) {
            LoginBean.DataBean data = loginBean.getData();
            int followNum = data.getFollowNum();
            int followerSize = data.getFollowerSize();
            String nickName = data.getNickName();
            String cover = data.getCover();
            Glide.with(getContext()).load(cover).bitmapTransform(new GlideCircleTransform(getContext())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(mindUserphoto);
            mindUserName.setText(nickName);
            personageFocusNumTv.setText(followNum+"");
            personageFansNumTv.setText(followerSize+"");


        }


    }
}
