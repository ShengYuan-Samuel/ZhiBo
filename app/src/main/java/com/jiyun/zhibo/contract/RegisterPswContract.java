package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.model.entify.RegisterPhoneBean;

import retrofit2.http.Field;

public interface RegisterPswContract {

    interface View{
        void showRegisterPswData(RegisterPhoneBean registerPhoneBean);
        void showErrorMessage(String error);
        void showRegLoginData(LoginBean loginBean);

    }
    interface Presenter extends BasePresenter<View>{
        void getRegisterPswData( String phone, String captch,
                                 String avatar, int sex,String password);
        void getRegLoginData(String phone,String code);
        boolean isCheckPsw(String psw);


    }
}
