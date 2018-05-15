package com.jiyun.zhibo.base;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.jiyun.zhibo.App;
import com.jiyun.zhibo.R;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏掉系统原先的导航栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayOutId());

        if (ImmersionBar.hasNavigationBar(this)) {//判断是否有导航栏
            ImmersionBar
                    .with(this)
                    .statusBarColor(R.color.grey)
                   .navigationBarColor(R.color.colorBlack)
                    .init();
        } else {
            ImmersionBar
                    .with(this)
                    .statusBarColor(R.color.grey)
                    .init();
            Toast.makeText(this, "当前设备没有导航栏", Toast.LENGTH_SHORT).show();
        }
        App.contxt = this;
        ButterKnife.bind(this);
        presenter =getPresenter();
        if (presenter != null){
            presenter.attachView(this);
        }
        init();
        loadData();
    }

    //这是统一创建presenter 的 和创建view
    private T getPresenter(){
        Type type = getClass().getGenericSuperclass();
        if (type.equals(BaseActivity.class))
            return null;
        Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
        if (arguments.length == 0)
            return null;
        Class<T> argument = (Class<T>) arguments[0];
        try {
            T t = argument.newInstance();
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }
    //这是统一返回layout的
    protected abstract int getLayOutId();
    //这是统一初始化的
    protected abstract void init();
    //这是统一加载数据的
    protected abstract void loadData();

    @Override
    protected void onStop() {
        super.onStop();
        App.contxt = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }

    //这是统一管理fragment
    private BaseFragment lastFragment;
    public BaseFragment setContentView(int content,Class<? extends BaseFragment> fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        String simpleName = fragment.getSimpleName();
        BaseFragment fragmentByTag = (BaseFragment) supportFragmentManager.findFragmentByTag(simpleName);
            try {
                if (fragmentByTag == null){
                fragmentByTag = fragment.newInstance();
                transaction.add(content,fragmentByTag,simpleName);
                }
                if (lastFragment != null){
                    transaction.hide(lastFragment);
                }
                transaction.show(fragmentByTag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
        }
        lastFragment = fragmentByTag;
        transaction.commit();
        return fragmentByTag;
    }
}
