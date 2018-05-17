package com.jiyun.zhibo.ui;

import android.content.Intent;
import android.os.Handler;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;

public class WelocomeActivity extends BaseActivity {



    @Override
    protected int getLayOutId() {
        return R.layout.activity_welocome;
    }

    @Override
    protected void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelocomeActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
                //动画效果实现 要在finish()或者startActivity()之后
                overridePendingTransition(R.anim.trn_in, R.anim.trn_out);
            }
        },600);

    }

    @Override
    protected void loadData() {

    }


}
