package com.jiyun.zhibo.presenter;

import android.util.Log;

import com.jiyun.zhibo.contract.ZiYouBoContract;
import com.jiyun.zhibo.model.biz.ZiYouBoService;
import com.jiyun.zhibo.model.entify.OpenRoomBean;
import com.jiyun.zhibo.model.http.HttpFactory;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.utils.SignUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ZiYouBoPresenter implements ZiYouBoContract.Presenter{

    private final ZiYouBoService ziYouBoService;
    private ZiYouBoContract.View view;
    public ZiYouBoPresenter() {
        ziYouBoService = HttpFactory.create().getZiYouBoService();
    }

    @Override
    public void getOpenRoomData(String position, String menuNo, String name) {
        if ("".equals(name)){
            view.showErrorMeg("请填写直播间名称");
            return;
        }else{


        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("position",position);
        hashMap.put("menuNo",menuNo);
        hashMap.put("name",name);
        hashMap.put("time",SavaShareUtils.getInstance().getTime());
        String sign = SignUtils.getSign(hashMap, SavaShareUtils.getInstance().getToken());
        SavaShareUtils.getInstance().setSign(sign);
        String token = SavaShareUtils.getInstance().getToken();
        ziYouBoService.getOpenRoomData(SavaShareUtils.getInstance().getUserNo(),SignUtils.getSign(hashMap,token)
        ,SavaShareUtils.getInstance().getTime(),position,menuNo,name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OpenRoomBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OpenRoomBean openRoomBean) {
                        view.showOpenRoomData(openRoomBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("aaaa",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        }
    }

    @Override
    public void attachView(ZiYouBoContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
