package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.LoginBean;

public interface MyLoginContract {

    interface View{
        void showUserInFo(LoginBean loginBean);

    }
    interface Presenter extends BasePresenter<View>{
        void getUserInFoData();
    }
}
