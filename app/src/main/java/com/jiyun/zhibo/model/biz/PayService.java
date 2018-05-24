package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.DingDanBean;
import com.jiyun.zhibo.model.entify.MoneyDataBean;
import com.jiyun.zhibo.model.entify.PayInFoData;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PayService {

    //这个是获取个人信息的
    @FormUrlEncoded
    @POST("user/userVc")
    Observable<PayInFoData> getPayInFo(@Field("time") String time, @Header("userNo") String userNo, @Header("sign") String sign);
    //这个是获取金币列表的
    @GET("vc/list")
    Observable<MoneyDataBean> getMoneyData();

    //这是获取支付订单的

    @FormUrlEncoded
    @POST("order/add")
    Observable<DingDanBean> getAddInFo(@Header("userNo") String userNo, @Header("sign") String sign, @Field("type") String type, @Field("isIntegral") String isIntegral, @Field("isVouchers") String isVouchers, @Field("extendNo") String extendNo , @Field("time") String time);

    //这是获取支付宝App的

    @FormUrlEncoded
    @POST("order/createAliyun")
    Observable<ResponseBody> getZhiFuBaoData(@Header("userNo") String userNo, @Header("sign") String sign,@Field("orderNo") String orderNo,@Field("time") String time);






}
