package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.model.entify.RegisterPhoneBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterPswService{
    @FormUrlEncoded
    @POST("user/regPhone")
    Observable<RegisterPhoneBean> getRegisterPswData(@Field("phone") String phone,@Field("captch") String captch,
                                                     @Field("avatar") String avatar,@Field("sex") int sex,@Field("password") String password);

    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> getRegLoginData(@Field("phone") String phone,@Field("captch") String code);


}
