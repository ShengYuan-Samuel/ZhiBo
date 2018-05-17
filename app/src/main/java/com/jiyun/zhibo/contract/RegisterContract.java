package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.GetCodeBean;

import retrofit2.http.Field;

public interface RegisterContract {

    interface View{
            //这是错误的信息

            void showErrorMessage(String errorMessage);
            void showCodeData(GetCodeBean getCodeBean);
    }
        interface Presenter extends BasePresenter<View>{
        //这是获取验证码的
        void getCodeData(String phone);
        //这是判断手机号的
        boolean isCheckPhone(String string);
    }
}
