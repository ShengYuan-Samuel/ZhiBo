package com.jiyun.zhibo.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SignUtils {

  public static String getSign(HashMap<String,String> hashMap,String token){
      //获取Ascll编码排序字符串
      String asxxllString = AscllMap(hashMap);
      String sign = asxxllString + "&key=" +token;
      String signs = Md5Util.encrypt(sign).toUpperCase();
      return signs;

  }

    //ASCLL编码排序
    public static String AscllMap(HashMap map){
        Collection<String> keyset= map.keySet();

        List list=new ArrayList<String>(keyset);

        Collections.sort(list);
        //这种打印出的字符串顺序和微信官网提供的字典序顺序是一致的
        String stringBuilder  = new String();
        for(int i=0;i<list.size();i++){
            stringBuilder = stringBuilder+list.get(i)+"="+map.get(list.get(i))+"&";
//            System.out.println(list.get(i)+"="+map.get(list.get(i)));
        }
       // LogUtil.Log("helper",LogUtil.LOG_E,stringBuilder.substring(0,stringBuilder.length()-1));
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
