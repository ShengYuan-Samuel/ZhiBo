package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.LoginBean;

import retrofit2.http.Field;

public interface LoginContract {

    interface View{
        void showLoginData(LoginBean loginBean);
        void showErrorMessage(String meg);

    }
    interface Presenter extends BasePresenter<View>{
       void  getLoginData(String phone,String psw);
    }
}
