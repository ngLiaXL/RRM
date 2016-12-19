package com.ldroid.kwei.rrm.common.network;

import com.ldroid.kwei.rrm.services.ExpressService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ExpressRetrofit {

    private Retrofit retrofit;
    private static ExpressService instance;

    public ExpressRetrofit() {
        this.retrofit = (new Retrofit.Builder())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.createOkHttpClient())
                .baseUrl(AppAssembly.getUrl())
                .build();
    }

    public static ExpressService get() {
        if (instance == null) {
            instance = new ExpressRetrofit().create(ExpressService.class);
        }
        return instance;
    }

    public <T> T create(Class<T> service) {
        final Object serviceImpl = this.retrofit.create(service);
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
                Object result = method.invoke(serviceImpl, args);
                if (result != null && result instanceof Observable) {
                    Observable observable = (Observable) result;
                    return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                } else {
                    return result;
                }
            }
        });
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        return builder.build();
    }
}
