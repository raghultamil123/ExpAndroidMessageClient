package com.raghul.expenseclient.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.raghul.expenseclient.dto.MessageModel;
import com.raghul.expenseclient.repository.MessageRepository;
import com.raghul.expenseclient.util.MessageUtil;

import java.util.List;

public class SmsMessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            SmsMessage[] smsMessages = MessageUtil.getMessageFromBundle(bundle);
            if(smsMessages != null) {
                List<MessageModel> messageModels = MessageUtil.translateToMessageModelList(smsMessages);
                new MessageRepository(context).saveMessages(messageModels);
            }
        }
    }
}
