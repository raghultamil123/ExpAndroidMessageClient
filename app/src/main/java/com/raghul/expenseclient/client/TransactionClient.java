package com.raghul.expenseclient.client;

import com.raghul.expenseclient.dto.MessageModel;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.POST;

public interface TransactionClient {

    @POST("transaction/save")
    Call<Response> saveTransaction(MessageModel messageModel);
}
