package com.raghul.expenseclient.util;

import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsMessage;

import com.raghul.expenseclient.dto.MessageModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class MessageUtil {

    public static SmsMessage[] getMessageFromBundle(Bundle bundle){
        SmsMessage messages[] = null;

        Object[] pdus = (Object[]) (bundle.get("pdus"));
        if(pdus.length > 0){
            messages = new SmsMessage[pdus.length];
            for(int i = 0;i<pdus.length;i++){
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
        }

        return messages;
    }

    public static MessageModel translateToMessageModel(SmsMessage smsMessage){
        String amount = smsMessage.getMessageBody();
        String moneyStatus = getMoneyStatus(smsMessage.getMessageBody());
        return new MessageModel(amount,smsMessage.getDisplayOriginatingAddress(),"",moneyStatus,"");
    }

    public static String getMoneyStatus(String messageBody){
        if(messageBody.toLowerCase().contains("credited")){
            return "credited";
        }
        else if(messageBody.toLowerCase().contains("debited")){
            return "debited";
        }
        return "No Status";
    }

   public static List<MessageModel> translateToMessageModelList(SmsMessage[] smsMessages){
        List<MessageModel> models = new ArrayList<>();
        if(smsMessages != null){
            for(SmsMessage message:smsMessages){
                MessageModel model = translateToMessageModel(message);
                if(validModel(model)){
                    models.add(model);
                }
            }
            return  models;
        }

        return Collections.emptyList();
    }

    public static boolean validModel(MessageModel messageModel){
        if(messageModel.getMoneyStatus().equals("No Status") || messageModel.getAmount().isEmpty()){
            return false;
        }
        return true;
    }

    public static String getAmountFromMessage(String messageBody){
        Pattern pat = Pattern.compile(CommonConstants.AMOUNT_PATTERN);
        Matcher mat = pat.matcher(messageBody);
        String amount = "";
        int i = 0;
        while (mat.find()){
            if(mat.group().contains("Rs")||mat.group().contains("INR") ||mat.group().contains("RS")){
                amount = mat.group();
                amount = amount.replaceAll("[A-Za-z]+","");
                break;
            }
        }
        return amount;
    }

}
