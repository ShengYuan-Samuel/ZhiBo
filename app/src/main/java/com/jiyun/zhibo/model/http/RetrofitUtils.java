package com.jiyun.zhibo.model.http;

import android.text.TextUtils;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jiyun.zhibo.App;
import com.jiyun.zhibo.model.biz.RegisterPswService;
import com.jiyun.zhibo.model.biz.RegisterService;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils retiofitUtils;
    private final Retrofit retrofit;

    public RetrofitUtils() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (TextUtils.isEmpty(response.cacheControl().toString())) {
                    return response.newBuilder().addHeader("Cache-Control", "max-age=60*60*24").build();
                }
                /*Headers headers = response.headers();
                Set<String> names = headers.names();
                for (String name : names) {
                    String s = headers.get(name);
                    Log.d("RetrofitUtils", name + ":------" + s);
                }*/
                return response;
            }
        };
        Cache cache1 = new Cache(App.contxt.getCacheDir(), 1024 * 1024 * 20);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .cache(cache1)
                .addNetworkInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Urls.APPSERVICEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitUtils getInstance() {
        if (retiofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retiofitUtils == null)
                    retiofitUtils = new RetrofitUtils();
            }
        }
        return retiofitUtils;
    }
    //这是获取验证码的
    public RegisterService getRegisterService(){
        return retrofit.create(RegisterService.class);
    }
    //这是手机完善信息的
    public RegisterPswService getRegsterPswService(){
        return retrofit.create(RegisterPswService.class);
    }

}
