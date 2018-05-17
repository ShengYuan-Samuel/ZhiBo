package com.jiyun.zhibo.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.jiyun.zhibo.App;

public class KeyBoardUtils
{  
    /** 
     * 打卡软键盘 
     *  
     * @param mEditText 
     *            输入框 
     * @param mContext 
     *            上下文 
     */  
    public static void openKeybord(EditText mEditText, Context mContext)
    {  
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);  
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);  
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,  
                InputMethodManager.HIDE_IMPLICIT_ONLY);  
    }  
  
    /** 
     * 关闭软键盘 
     *  
     * @param mEditText 
     *            输入框 
     * @param mContext 
     *            上下文 
     */  
    public static void closeKeybord(EditText mEditText, Context mContext)  
    {  
        InputMethodManager imm = (InputMethodManager) mContext  
                .getSystemService(Context.INPUT_METHOD_SERVICE);  
  
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);  
    }
    public static void hideSoftInput(Activity acitivity) {
        InputMethodManager imm = (InputMethodManager) acitivity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(acitivity.getWindow().getDecorView()
                        .getApplicationWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

}  