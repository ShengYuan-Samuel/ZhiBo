package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.MoneyDataBean;
import com.jiyun.zhibo.model.entify.PayInFoData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PayService {
    @FormUrlEncoded
    @POST("user/userVc")
    Observable<PayInFoData> getPayInFo(@Field("time") String time, @Header("userNo") String userNo, @Header("sign") String sign);

    @GET("vc/list")
    Observable<MoneyDataBean> getMoneyData();


}
