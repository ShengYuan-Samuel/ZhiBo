package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {


    //这是登录获取信息的
    @FormUrlEncoded
    @POST("user/loginPwd")
    Observable<LoginBean> getLoginData(@Field("phone") String phone,@Field("password") String psw);



}
