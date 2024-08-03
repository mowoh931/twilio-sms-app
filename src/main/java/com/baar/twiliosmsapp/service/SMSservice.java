package com.baar.twiliosmsapp.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "smSservice")
public class SMSservice {

    @Value("${Account_SID}")
    protected String ACCOUNT_SID;
    @Value("${Auth_Token}")
    protected String AUTH_TOKEN;
    @Value("${Account_Phone}")
    protected String ACCOUNT_PHONE;

    public SMSservice() {
    }

    private final Logger logger = LoggerFactory.getLogger(SMSservice.class);

    public String sendMessage(String outPhoneNo, String sms) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            logger.info("Twilio initialized");
        } catch (Exception e) {
            logger.error("Error initializing Twilio");
            logger.error("Initializing error: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        String phone = ACCOUNT_PHONE;
        Message message = null;
        try {
            message = Message.creator(
                            new PhoneNumber(outPhoneNo)
                            , new PhoneNumber(phone)
                            , sms)
                    .create();
            logger.info("Message sent to: {} with message: {}", outPhoneNo, sms);
        } catch (Exception e) {
            logger.error("Error sending message to: {} with message: {}", outPhoneNo, sms);
            logger.error("Error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return message.getSid();
    }
}
