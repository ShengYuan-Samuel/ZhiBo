package com.jiyun.zhibo.contract;

import com.jiyun.zhibo.base.BasePresenter;
import com.jiyun.zhibo.model.entify.DingDanBean;
import com.jiyun.zhibo.model.entify.MoneyDataBean;
import com.jiyun.zhibo.model.entify.PayInFoData;

import retrofit2.http.Field;
import retrofit2.http.Header;

public interface PayContract {

    interface View{
        void showPayInFoData(PayInFoData payInFoData);

        void showMoneyData(MoneyDataBean moneyDataBean);

        void showAddInFo(DingDanBean str);

        void showZhiFuBaoData(String str);


    }
    interface Presenter extends BasePresenter<View>{
        void getPayInFo();

        void getMoneyData();

       void  getAddInFo(String type, String isIntegral,  String isVouchers,  String extendNo);


        void getZhiFuBaoData(String orderNo);
    }
}
