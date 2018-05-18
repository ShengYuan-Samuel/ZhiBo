package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.contract.MyLoginContract;
import com.jiyun.zhibo.model.biz.MyLoginService;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.model.http.HttpFactory;
import com.jiyun.zhibo.utils.SavaShareUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyLoginPresenter implements MyLoginContract.Presenter {
    private MyLoginContract.View view;
    private final MyLoginService myLoginService;

    public MyLoginPresenter() {
        myLoginService = HttpFactory.create().getMyLoginService();
    }

    @Override
    public void getUserInFoData() {
        myLoginService.getUserInFo(SavaShareUtils.getInstance().getTime(),SavaShareUtils.getInstance().getUserNo(),SavaShareUtils.getInstance().getSign())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        view.showUserInFo(loginBean);

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
    public void attachView(MyLoginContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
