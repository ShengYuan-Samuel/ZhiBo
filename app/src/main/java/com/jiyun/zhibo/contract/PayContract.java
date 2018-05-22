package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.MoneyDataBean;
import com.jiyun.zhibo.model.entify.PayInFoData;

public interface PayContract {

    interface View{
        void showPayInFoData(PayInFoData payInFoData);

        void showMoneyData(MoneyDataBean moneyDataBean);
    }
    interface Presenter extends BasePresenter<View>{
        void getPayInFo();

        void getMoneyData();
    }
}
