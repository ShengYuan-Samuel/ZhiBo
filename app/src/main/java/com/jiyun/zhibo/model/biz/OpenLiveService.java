package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.GiftBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OpenLiveService {
    @FormUrlEncoded
    @POST("gift/getlist")
    Observable<GiftBean> getGiftBean(@Field("length") String length);
}
