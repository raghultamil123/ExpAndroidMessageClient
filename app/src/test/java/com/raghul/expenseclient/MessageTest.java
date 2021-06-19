package com.raghul.expenseclient;

import com.raghul.expenseclient.util.MessageUtil;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {


    @Test
    public void getAmountTest(){
        String amount = MessageUtil.getAmountFromMessage("Dear SBI UPI USER ur ACdsdsd debited by Rs450.00 on 11Jun20");
        Assert.assertEquals("450.00",amount);
    }

    @Test
    public void getMoneyStatus(){
        String status = MessageUtil.getMoneyStatus("Dear SBI UPI USER ur ACdsdsd Debited by Rs450.00 on 11Jun20");
        Assert.assertEquals("debited",status);
    }
}
