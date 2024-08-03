package com.baar.twiliosmsapp.api;

import com.baar.twiliosmsapp.model.SMSRequest;
import com.baar.twiliosmsapp.service.SMSservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSaPi {

    private final SMSservice smSservice;

    public SMSaPi(SMSservice smSservice) {
        this.smSservice = smSservice;
    }

    @PostMapping("/send")
    public String sendSms(@RequestBody SMSRequest smsRequest) {
        smSservice.sendMessage(smsRequest.getDestinationPhoneNumber(), smsRequest.getSmsMessage());
        return smsRequest.getSmsMessage();
    }
}
