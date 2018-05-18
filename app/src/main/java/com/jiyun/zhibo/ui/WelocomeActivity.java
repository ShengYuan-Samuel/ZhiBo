package com.jiyun.zhibo.ui;

import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.ui.login.activity.LoginActivity;
import com.jiyun.zhibo.utils.SavaShareUtils;

public class WelocomeActivity extends BaseActivity {



    @Override
    protected int getLayOutId() {
        return R.layout.activity_welocome;
    }

    @Override
    protected void init() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              /*  if (SavaShareUtils.getInstance().getUserNo() == null){
                   // Intent intent = new Intent(WelocomeActivity.this,LoginActivity.class);
                //    startActivity(intent);
                   // finish();
                    //动画效果实现 要在finish()或者startActivity()之后
                    overridePendingTransition(R.anim.trn_in, R.anim.trn_out);
                }else{*/
                    Intent intent = new Intent(WelocomeActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                    //动画效果实现 要在finish()或者startActivity()之后
                    overridePendingTransition(R.anim.trn_in, R.anim.trn_out);
          /*      }
*/
            }
        },600);

    }

    @Override
    protected void loadData() {

    }


}
