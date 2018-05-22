package com.jiyun.zhibo.ui.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.contract.LoginContract;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.presenter.LoginPresenter;
import com.jiyun.zhibo.ui.HomeActivity;
import com.jiyun.zhibo.ui.register.RegisterActivity;
import com.jiyun.zhibo.utils.KeyBoardUtils;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.utils.SignUtils;
import com.jiyun.zhibo.utils.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.login_return)
    ImageView loginReturn;
    @BindView(R.id.login_seeting)
    ImageView loginSeeting;
    @BindView(R.id.login_phoneEt)
    EditText loginPhoneEt;
    @BindView(R.id.login_pswEt)
    EditText loginPswEt;
    @BindView(R.id.notlogin_tv)
    TextView notloginTv;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_weiXinBtu)
    ImageView loginWeiXinBtu;
    @BindView(R.id.login_qqBtu)
    ImageView loginQqBtu;
    @BindView(R.id.login_phoneBtu)
    ImageView loginPhoneBtu;
    @BindView(R.id.login_regiter)
    LinearLayout loginRegiter;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.login_btn,R.id.notlogin_tv,R.id.login_return, R.id.login_seeting, R.id.login_weiXinBtu, R.id.login_qqBtu, R.id.login_phoneBtu, R.id.login_regiter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_return:
                KeyBoardUtils.hideSoftInput(this);
                finish();
                break;
            case R.id.login_seeting:

                break;
            case R.id.login_weiXinBtu:
                break;
            case R.id.login_qqBtu:
                break;
            case R.id.login_phoneBtu:
                break;
            case R.id.login_regiter:
                startActivity(new Intent(this,RegisterActivity.class));
                finish();
                break;
            case R.id.notlogin_tv:
                break;
            case R.id.login_btn:
                presenter.getLoginData(loginPhoneEt.getText().toString().trim(),loginPswEt.getText().toString().trim());

                break;
        }
    }

    @Override
    public void showLoginData(LoginBean loginBean) {
        if (loginBean ==null){
            return;
        }
        if (Integer.valueOf(loginBean.getCode())==200){
            SavaShareUtils.getInstance().setToken(loginBean.getData().getToken());
            SavaShareUtils.getInstance().setUserNo(loginBean.getData().getUserNo());
            String nickName = loginBean.getData().getNickName();
            String cover = loginBean.getData().getCover();
            SavaShareUtils.getInstance().setPhoto(cover);
            SavaShareUtils.getInstance().setName(nickName);
            long time = System.currentTimeMillis();
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("time",String.valueOf(time));
            String sign = SignUtils.getSign(hashMap,SavaShareUtils.getInstance().getToken());
            SavaShareUtils.getInstance().setSign(sign);
            SavaShareUtils.getInstance().setTime(time+"");
            //startActivity(new Intent(this, HomeActivity.class));
            finish();
        }


    }

    @Override
    public void showErrorMessage(String meg) {
        ToastUtil.showShort(this,meg);

    }
}
