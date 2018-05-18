package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.contract.LoginContract;
import com.jiyun.zhibo.model.biz.LoginService;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.model.http.HttpFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View view;
    private final LoginService loginService;

    public LoginPresenter() {
        loginService = HttpFactory.create().getLoginService();
    }

    @Override
    public void getLoginData(String phone, String psw) {
        loginService.getLoginData(phone,psw)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        view.showLoginData(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        view.showErrorMessage(message);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(LoginContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view =null;
    }
}
