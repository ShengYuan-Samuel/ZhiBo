package com.jiyun.zhibo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.zhibo.App;

public class SavaShareUtils {
    private static SavaShareUtils savaShareUtils;
    private final SharedPreferences sharedPreferences;
    public final String YIZIAN = "yixian";
    private final SharedPreferences.Editor edit;

    public SavaShareUtils() {
        sharedPreferences = App.contxt.getSharedPreferences(YIZIAN, App.contxt.MODE_PRIVATE);
        edit = sharedPreferences.edit();
    }
    public static SavaShareUtils getInstance(){
        if (savaShareUtils == null){
            synchronized (SavaShareUtils.class){
                if (savaShareUtils == null)
                    savaShareUtils = new SavaShareUtils();
            }
        }
        return savaShareUtils;
    }
    //这是保存token的
    public void setToken(String token){
        edit.putString("token",token);
        edit.commit();
    }
    //这是获取token的
    public String getToken(){
        return sharedPreferences.getString("token",null);
    }
    //这是保存userNo的
    public void setUserNo(String userNo){
        edit.putString("userNo",userNo);
        edit.commit();
    }
    //这是获取userNo的
    public String getUserNo(){
        return sharedPreferences.getString("userNo",null);
    }
    //这是保存sign的
    public void setSign(String sign){
        edit.putString("sign",sign);
        edit.commit();
    }
    //这是获取sign的
    public String getSign(){
        return sharedPreferences.getString("sign",null);
    }

    //这是保存当前时间的
    public void setTime(String time){
        edit.putString("time",time);
        edit.commit();
    }
    //这是获取保存的时间的
    public String getTime(){
        return sharedPreferences.getString("time",null);
    }



}
