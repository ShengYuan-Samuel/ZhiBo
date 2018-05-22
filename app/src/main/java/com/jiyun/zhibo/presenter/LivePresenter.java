package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.contract.LiveContract;
import com.jiyun.zhibo.model.biz.LiveService;
import com.jiyun.zhibo.model.entify.LunBoBeans;
import com.jiyun.zhibo.model.entify.RenQiBean;
import com.jiyun.zhibo.model.http.HttpFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LivePresenter implements LiveContract.Presenter{
    private LiveContract.View view;
    private final LiveService liveService;

    public LivePresenter() {
        liveService = HttpFactory.create().getLiveService();
    }

    @Override
    public void getLunBoBeans() {
        liveService.getLunBoBeans()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LunBoBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LunBoBeans lunBoBeans) {
                        view.showLunBoBean(lunBoBeans);
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
    public void getRenQiData() {
        liveService.getRenQiData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RenQiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RenQiBean renQiBean) {
                        view.showRenQiData(renQiBean);
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
    public void getTuiJianData() {
        liveService.getTuiJianData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RenQiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RenQiBean renQiBean) {
                        view.showTuiJianData(renQiBean);

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
    public void attachView(LiveContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
