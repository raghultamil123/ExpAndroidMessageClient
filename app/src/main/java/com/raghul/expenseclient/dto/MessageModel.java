package com.raghul.expenseclient.dto;

public class MessageModel {

    private String amount;
    private String fromBank;
    private String userMobileNumberId;
    private String moneyStatus;
    private String userId;

    public MessageModel(){

    }

    public MessageModel(String amount,String fromBank,String userMobileNumber,String moneyStatus
    ,String userId){
        this.amount = amount;
        this.fromBank = fromBank;
        this.userMobileNumberId = userMobileNumber;
        this.moneyStatus = moneyStatus;
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFromBank() {
        return fromBank;
    }

    public void setFromBank(String fromBank) {
        this.fromBank = fromBank;
    }

    public String getUserMobileNumberId() {
        return userMobileNumberId;
    }

    public void setUserMobileNumberId(String userMobileNumberId) {
        this.userMobileNumberId = userMobileNumberId;
    }

    public String getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(String moneyStatus) {
        this.moneyStatus = moneyStatus;
    }
}
