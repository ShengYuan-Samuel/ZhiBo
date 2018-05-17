package com.jiyun.zhibo.ui.register;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jiyun.zhibo.App;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.contract.RegisterContract;
import com.jiyun.zhibo.model.entify.GetCodeBean;
import com.jiyun.zhibo.presenter.RegisterPresenter;
import com.jiyun.zhibo.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {


    @BindView(R.id.register_return)
    ImageView registerReturn;
    @BindView(R.id.register_phoneEt)
    EditText registerPhoneEt;
    @BindView(R.id.register_codeEt)
    EditText registerCodeEt;
    @BindView(R.id.register_getcodeBtn)
    Button registerGetcodeBtn;
    @BindView(R.id.register_btn)
    Button registerBtn;
    private int time = 60;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int time = (int) msg.obj;
            registerGetcodeBtn.setText("重新发送" + "("+time + "s)");
            mHandler.postDelayed(runnable, 1000);
            if (time == 0) {
                mHandler.removeCallbacks(runnable);
                registerGetcodeBtn.setText("重新发送");
                registerGetcodeBtn.setClickable(true);
            }
        }
    };

    @Override
    protected int getLayOutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
    }

    @OnClick({R.id.register_return, R.id.register_getcodeBtn, R.id.register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_return:
                finish();
                break;
            case R.id.register_getcodeBtn:
                registerCodeEt.setText("");
                time = 60;
                mHandler.postDelayed(runnable, 1000);
                registerGetcodeBtn.setClickable(false);
                presenter.getCodeData(registerPhoneEt.getText().toString().trim());
                break;
            case R.id.register_btn:
                String phone = registerPhoneEt.getText().toString().trim();
                String code = registerCodeEt.getText().toString().trim();
                Intent intent = new Intent(this, RegisterPswActivity.class);
                intent.putExtra("phone",phone);
                intent.putExtra("code",code);
                startActivity(intent);
                break;
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            Message message = mHandler.obtainMessage();
            message.obj = time;
            mHandler.sendMessage(message);
        }
    };

    @Override
    public void showErrorMessage(String errorMessage) {
        ToastUtil.showShort(this, errorMessage);
    }

    @Override
    public void showCodeData(GetCodeBean getCodeBean) {
        if (getCodeBean == null)
            return;
        String data = getCodeBean.getData();
        String code = getCodeBean.getCode();
        if (data != null)
            registerCodeEt.setText(data);
    }


}
