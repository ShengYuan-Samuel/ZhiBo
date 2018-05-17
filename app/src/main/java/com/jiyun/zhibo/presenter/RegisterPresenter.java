package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.App;
import com.jiyun.zhibo.contract.RegisterContract;
import com.jiyun.zhibo.model.biz.RegisterService;
import com.jiyun.zhibo.model.entify.GetCodeBean;
import com.jiyun.zhibo.model.http.HttpFactory;
import com.jiyun.zhibo.utils.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private final RegisterService registerService;
    String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
    public RegisterPresenter() {
        registerService = HttpFactory.create().getRegisterService();
    }

    @Override
    public void getCodeData(String phone) {
        if (isCheckPhone(phone) == false){
            view.showErrorMessage("请输入正确的手机号");
            return;
        }

            registerService.getCodeData(phone)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<GetCodeBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }
                        @Override
                        public void onNext(GetCodeBean getCodeBean) {
                            view.showCodeData(getCodeBean);
                        }
                        @Override
                        public void onError(Throwable e) {
                        }
                        public void onComplete() {
                        }
                    });
    }

    @Override
    public boolean isCheckPhone(String string) {
        if (string.matches(PHONE_NUMBER_REG)){
            return true;
        }else{
          return false;
        }
    }


    @Override
    public void attachView(RegisterContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
