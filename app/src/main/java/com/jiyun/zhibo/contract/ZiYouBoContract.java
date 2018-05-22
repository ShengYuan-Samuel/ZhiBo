package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.OpenRoomBean;

public interface ZiYouBoContract {

    interface View{
        void showOpenRoomData(OpenRoomBean openRoomBean);
        void showErrorMeg(String error);

    }
    interface Presenter extends BasePresenter<View>{
        void getOpenRoomData(String position, String menuNo,String name);
    }
}
