package com.jiyun.zhibo.presenter;

import com.jiyun.zhibo.contract.PayContract;
import com.jiyun.zhibo.model.biz.PayService;
import com.jiyun.zhibo.model.entify.MoneyDataBean;
import com.jiyun.zhibo.model.entify.PayInFoData;
import com.jiyun.zhibo.model.http.HttpFactory;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.utils.SignUtils;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class PayPresenter implements PayContract.Presenter{

    private PayContract.View view;
    private final PayService payService;

    public PayPresenter() {
        payService = HttpFactory.create().getPayService();
    }

    @Override
    public void getPayInFo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("time",SavaShareUtils.getInstance().getTime());
        String token = SavaShareUtils.getInstance().getToken();
        payService.getPayInFo(SavaShareUtils.getInstance().getTime(),SavaShareUtils.getInstance().getUserNo(), SignUtils.getSign(map,token))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayInFoData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayInFoData payInFoData) {

                            view.showPayInFoData(payInFoData);


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
    public void getMoneyData() {
        payService.getMoneyData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoneyDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoneyDataBean moneyDataBean) {
                        view.showMoneyData(moneyDataBean);
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
    public void attachView(PayContract.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
