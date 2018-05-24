package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.contract.OpenLiveContract;
import com.jiyun.zhibo.model.biz.OpenLiveService;
import com.jiyun.zhibo.model.entify.GiftBean;
import com.jiyun.zhibo.model.http.HttpFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OpenLivePresenter implements OpenLiveContract.Presenter {
    private OpenLiveContract.View view;
    private final OpenLiveService openLiveService;

    public OpenLivePresenter() {
        openLiveService = HttpFactory.create().getOpenLiveService();

    }

    @Override
    public void getGiftBean() {
        openLiveService.getGiftBean("18")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GiftBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GiftBean giftBean) {
                        view.showGiftBean(giftBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(OpenLiveContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
