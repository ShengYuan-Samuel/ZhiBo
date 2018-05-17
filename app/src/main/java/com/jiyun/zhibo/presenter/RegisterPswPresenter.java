package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.contract.RegisterPswContract;
import com.jiyun.zhibo.model.biz.RegisterPswService;
import com.jiyun.zhibo.model.entify.LoginBean;
import com.jiyun.zhibo.model.entify.RegisterPhoneBean;
import com.jiyun.zhibo.model.http.HttpFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPswPresenter implements RegisterPswContract.Presenter{
    private RegisterPswContract.View view;
    private final RegisterPswService regsterPswService;
    String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$";
    public RegisterPswPresenter() {
        regsterPswService = HttpFactory.create().getRegsterPswService();
    }

    @Override
    public void getRegisterPswData(String phone, String captch, String avatar, int sex, String password) {
        if (isCheckPsw(password)==false){
            view.showErrorMessage("请输入正确的密码");
            return;
        }
        regsterPswService.getRegisterPswData(phone, captch, avatar, sex, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterPhoneBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterPhoneBean registerPhoneBean) {
                        view.showRegisterPswData(registerPhoneBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showErrorMessage(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getRegLoginData(String phone, String code) {
        regsterPswService.getRegLoginData(phone, code)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        view.showRegLoginData(loginBean);
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
    public boolean isCheckPsw(String psw) {
        if (psw.matches(regStr)){
            return true;
        }else{
        return false;
        }
    }

    @Override
    public void attachView(RegisterPswContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
