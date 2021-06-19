package com.raghul.expenseclient.config;

import com.raghul.expenseclient.util.CommonConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static RetrofitClient retrofitClient;


    private RetrofitClient(){
        retrofit = new Retrofit.Builder().baseUrl(CommonConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance(){
        if(retrofit == null)
            retrofitClient = new RetrofitClient();
        return retrofitClient;
    }

    public <T> T getService(Class<T> serviceClass){
        return retrofit.create(serviceClass);
    }
}
