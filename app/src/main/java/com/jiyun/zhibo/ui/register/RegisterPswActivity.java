package com.jiyun.zhibo.ui.register;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.contract.RegisterPswContract;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.model.entify.RegisterPhoneBean;
import com.jiyun.zhibo.presenter.RegisterPswPresenter;
import com.jiyun.zhibo.ui.my.fragment.MyFragment;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.utils.SignUtils;
import com.jiyun.zhibo.utils.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterPswActivity extends BaseActivity<RegisterPswPresenter> implements RegisterPswContract.View{


    @BindView(R.id.login_return)
    ImageView loginReturn;
    @BindView(R.id.registerpsw_Et)
    EditText registerpswEt;
    @BindView(R.id.registerPsw_btn)
    Button registerPswBtn;
    private String phone;
    private String codes;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_register_psw;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        codes = intent.getStringExtra("code");

    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.login_return, R.id.registerPsw_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_return:
                finish();
                break;
            case R.id.registerPsw_btn:
                presenter.getRegisterPswData(phone,codes,null,0,registerpswEt.getText().toString().trim());

                break;
        }
    }


    @Override
    public void showRegisterPswData(RegisterPhoneBean registerPhoneBean) {
        String code = registerPhoneBean.getCode();
        if (Integer.valueOf(code) == 200){
            presenter.getRegLoginData(phone,codes);

        }else{
        ToastUtil.showShort(this,"用户存在");
        presenter.getRegLoginData(phone,codes);
        }
    }

    @Override
    public void showErrorMessage(String error) {
        ToastUtil.showShort(this,error);

    }
    @Override
    public void showRegLoginData(LoginBean loginBean) {
        if (loginBean ==null)
            return;
        if (Integer.valueOf(loginBean.getCode()) == 200){
            String userNo = loginBean.getData().getUserNo();
            String token = loginBean.getData().getToken();
            SavaShareUtils.getInstance().setToken(token);
            SavaShareUtils.getInstance().setUserNo(userNo);
            long time = System.currentTimeMillis();
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("time",String.valueOf(time));
            String sign = SignUtils.getSign(hashMap, loginBean.getData().getToken());
            SavaShareUtils.getInstance().setSign(sign);
            SavaShareUtils.getInstance().setTime(time+"");
            finish();
        }

    }

}
