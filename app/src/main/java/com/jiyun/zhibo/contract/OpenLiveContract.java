package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.GiftBean;

public interface OpenLiveContract {

    interface View{
        void showGiftBean(GiftBean giftBean);

    }
    interface Presenter extends BasePresenter<View>{
       void  getGiftBean();
    }
}
