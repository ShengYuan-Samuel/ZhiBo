package com.jiyun.zhibo.base;

public interface BasePresenter<T> {
    /*
    这是维护生命周期的两个方法
     */
    void attachView(T t);
    void detachView();
}
