package com.jiyun.zhibo.model.biz;



import com.jiyun.zhibo.model.entify.GetCodeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterService {

    //这是注册获取验证码的消息
    @FormUrlEncoded
    @POST("user/captch")
    Observable<GetCodeBean> getCodeData(@Field("phone") String phone);

}
