package com.jiyun.zhibo.ui.login.activity;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.jiyun.zhibo.App;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.utils.FileSizeUtil;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.zyyoona7.popup.EasyPopup;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class SeetingActivity extends BaseActivity {


    @BindView(R.id.setting_left_finish)
    ImageView settingLeftFinish;
    @BindView(R.id.setting_safety)
    RelativeLayout settingSafety;
    @BindView(R.id.setting_clearSize)
    TextView settingClearSize;
    @BindView(R.id.setting_clear)
    RelativeLayout settingClear;
    @BindView(R.id.setting_about)
    RelativeLayout settingAbout;
    @BindView(R.id.setting_contact)
    RelativeLayout settingContact;
    @BindView(R.id.setting_grade)
    RelativeLayout settingGrade;
    @BindView(R.id.setting_exit)
    RelativeLayout settingExit;
    private String absolutePath;
    private EasyPopup easyPopup;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_seeting;
    }

    @Override
    protected void init() {
        File cacheDir = App.contxt.getCacheDir();
        absolutePath = cacheDir.getAbsolutePath();
        String autoFileOrFilesSize = FileSizeUtil.getAutoFileOrFilesSize(absolutePath);
        settingClearSize.setText(autoFileOrFilesSize);
        initPopup();

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.setting_left_finish, R.id.setting_safety, R.id.setting_clear, R.id.setting_about, R.id.setting_contact, R.id.setting_grade, R.id.setting_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_left_finish:
                finish();
                break;
            case R.id.setting_safety:
                Toast.makeText(this, "账号与安全", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_clear:
                FileSizeUtil.deleteDirectory(absolutePath);
                settingClearSize.setText("0.00kb");

                break;
            case R.id.setting_about:
                break;
            case R.id.setting_contact:
                break;
            case R.id.setting_grade:
                break;
            case R.id.setting_exit:
                Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show();
                easyPopup.showAtLocation(findViewById(R.id.seeting_liner), Gravity.BOTTOM, 0, 0);

                break;
        }
    }

    @SuppressLint("ResourceAsColor")
    private void initPopup() {
        //是否允许点击PopupWindow之外的地方消失
//允许背景变暗
//变暗的透明度(0-1)，0为完全透明
//变暗的背景颜色
//指定任意 ViewGroup 背景变暗
        easyPopup = EasyPopup.create()
                .setContentView(this, R.layout.exit_popup_view)
                .setWidth(LinearLayout.LayoutParams.MATCH_PARENT)
                //是否允许点击PopupWindow之外的地方消失
                .setFocusAndOutsideEnable(true)
                //允许背景变暗
                .setBackgroundDimEnable(true)
                //变暗的透明度(0-1)，0为完全透明
                .setDimValue(0.4f)
                //变暗的背景颜色
                .setDimColor(R.color.colorTouMing)
                //指定任意 ViewGroup 背景变暗
                .setDimView((ViewGroup) findViewById(R.id.seeting_liner))
                .apply();
        easyPopup.findViewById(R.id.exit_btu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavaShareUtils.getInstance().clearUserInFo();
                finish();
                Toast.makeText(SeetingActivity.this, "我要退出了", Toast.LENGTH_SHORT).show();

            }
        });
        easyPopup.findViewById(R.id.exit_dimiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyPopup.dismiss();
            }
        });
    }
}
