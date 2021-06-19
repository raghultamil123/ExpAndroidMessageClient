package com.raghul.expenseclient.repository;

import android.content.Context;

import com.raghul.expenseclient.client.TransactionClient;
import com.raghul.expenseclient.config.RetrofitClient;
import com.raghul.expenseclient.dto.MessageModel;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MessageRepository {

    Context context;

    public MessageRepository(Context context){
        this.context = context;
    }

    public void saveMessages(List<MessageModel> messageModelList){
        for(int i = 0;i<messageModelList.size();i++){
            RetrofitClient.getInstance().getService(TransactionClient.class).saveTransaction(messageModelList.get(i))
            .enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    System.out.println(response.body());
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {

                }
            });
        }
    }
}
