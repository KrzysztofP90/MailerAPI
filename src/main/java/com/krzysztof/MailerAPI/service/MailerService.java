package com.krzysztof.MailerAPI.service;

import com.krzysztof.MailerAPI.model.DataContainer;
import org.springframework.stereotype.Component;

@Component("mailerService")
public class MailerService {

    public boolean sendEmail(DataContainer dataContainer) {
        return true;
    }
}
