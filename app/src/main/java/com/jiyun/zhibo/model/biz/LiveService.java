package com.jiyun.zhibo.model.biz;

import com.jiyun.zhibo.model.entify.LunBoBeans;
import com.jiyun.zhibo.model.entify.RenQiBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LiveService {
    //这是轮播图的
    @POST("ad/getList")
    Observable<LunBoBeans> getLunBoBeans();

    //这是人气主播页面的
    @POST("live/rankingList")
    Observable<RenQiBean> getRenQiData();


    //这个是推荐列表的
    @POST("live/getList")
    Observable<RenQiBean> getTuiJianData();
}
