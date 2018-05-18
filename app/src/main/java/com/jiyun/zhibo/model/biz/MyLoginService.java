package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MyLoginService {
    @FormUrlEncoded
    @POST("user/userInfo")
    Observable<LoginBean> getUserInFo(@Field("time") String time, @Header("userNo") String userNo,@Header("sign") String sign);
}
