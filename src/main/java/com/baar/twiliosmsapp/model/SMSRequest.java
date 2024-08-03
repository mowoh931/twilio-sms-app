package com.baar.twiliosmsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SMSRequest {

    private String destinationPhoneNumber;
    private String smsMessage;


}
