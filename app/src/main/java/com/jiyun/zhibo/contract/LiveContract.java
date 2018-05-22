package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.LunBoBeans;
import com.jiyun.zhibo.model.entify.RenQiBean;

public interface LiveContract {

    interface View{
        void showLunBoBean(LunBoBeans lunBoBeans);

        void showRenQiData(RenQiBean renQiBean);

        void showTuiJianData(RenQiBean renQiBean);
    }
    interface Presenter extends BasePresenter<View>{
        void getLunBoBeans();
        //这是获取人气主播的
        void getRenQiData();
        //这是获取推荐列表的
        void getTuiJianData();
    }
}
