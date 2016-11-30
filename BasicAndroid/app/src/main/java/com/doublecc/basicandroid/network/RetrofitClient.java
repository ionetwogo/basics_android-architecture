package com.doublecc.basicandroid.network;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * RetrofitClient
 * Created by Tamic on 2016-06-15.
 * {@link # https://github.com/NeglectedByBoss/RetrofitClient}
 */

public class RetrofitClient {
    public static String baseUrl = Api.BASE_URL;
    private GankApiService gankApi;
    private static final int DEFAULT_TIMEOUT = 5;
    private static OkHttpClient okHttpClient;
    private static Context mContext;
    private static RetrofitClient sNewInstance;
    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(baseUrl);

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder()
                    .addInterceptor(new LogInterceptor())
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static class SingletonHolder
    {
        private static RetrofitClient INSTANCE = new RetrofitClient(mContext);
    }

    public static RetrofitClient getInstance(Context context)
    {
        if (context != null)
        {
            mContext = context;
        }

        return SingletonHolder.INSTANCE;
    }

    public static RetrofitClient getInstance(Context context, String url)
    {
        if (context != null)
        {
            mContext = context;
        }

        sNewInstance = new RetrofitClient(context, url);
        return sNewInstance;
    }

    public static RetrofitClient getInstance(Context context, String url, Map headers)
    {
        if (context != null)
        {
            mContext = context;
        }
        sNewInstance = new RetrofitClient(context, url, headers);
        return sNewInstance;
    }

    private RetrofitClient(Context context)
    {

        this(context, baseUrl, null);
    }

    private RetrofitClient(Context context, String url)
    {

        this(context, url, null);
    }

    private RetrofitClient(Context context, String url, Map headers)
    {

        if (TextUtils.isEmpty(url))
        {
            url = baseUrl;
        }

        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .cookieJar(new NovateCookieManger(context))
                .addInterceptor(new BaseInterceptor(headers))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }


    /*

     */
    public static RetrofitClient getInstance(String url, Map header)
    {
        sNewInstance = new RetrofitClient(url, header);
        return sNewInstance;
    }

    private RetrofitClient(String url, Map headers)
    {

        if (TextUtils.isEmpty(url))
        {
            url = baseUrl;
        }

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }
    /**
     * ApiBaseUrl
     *
     * @param newApiBaseUrl
     */
    public static void changeApiBaseUrl(String newApiBaseUrl)
    {
        baseUrl = newApiBaseUrl;
        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl);
    }

    /**
     * ApiBaseUrl
     *
     * @param newApiHeaders
     */
    public static void changeApiHeader(Map<String, String> newApiHeaders)
    {

        okHttpClient.newBuilder().addInterceptor(new BaseInterceptor(newApiHeaders)).build();
        builder.client(httpClient.build()).build();
    }


    /**
     * Create an implementation of the API endpoints defined by the {@code service} interface.
     */
    public static <S> S createService(Class<S> serviceClass)
    {

        return builder.client(httpClient.build()).build().create(serviceClass);
    }

    public static <T> T execute(Observable<T> observable , Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        return null;
    }

    private static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }
}
