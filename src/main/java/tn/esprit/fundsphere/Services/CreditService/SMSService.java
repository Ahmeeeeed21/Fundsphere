package tn.esprit.fundsphere.Services.CreditService;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSService {
    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;
    @Value("${TWILIO_OUTGING_SMS_NUMBER}")
    String OUTGING_SMS_NUMBER;

    @PostConstruct
    private void setIDandTOKEN(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    public String sendSMS(String smsNum,String smsMessage){
        Message message = Message.creator(
                new PhoneNumber("+216".concat(smsNum)),
                new PhoneNumber(OUTGING_SMS_NUMBER),smsMessage).create();
        return message.getStatus().toString();
    }
}
