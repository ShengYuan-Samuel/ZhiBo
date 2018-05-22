package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.OpenRoomBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ZiYouBoService {
    @FormUrlEncoded
    @POST("live/openQcloudLive")
    Observable<OpenRoomBean> getOpenRoomData(@Header("userNo") String userNo, @Header("sign") String sign, @Field("time") String time,@Field("position") String position, @Field("menuNo") String menuNo, @Field("name") String name);
}
