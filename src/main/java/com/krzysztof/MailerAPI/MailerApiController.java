package com.krzysztof.MailerAPI;


import com.krzysztof.MailerAPI.model.DataContainer;
import com.krzysztof.MailerAPI.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mailer")
public class MailerApiController {

    @Autowired
     private MailerService mailerService;

    @PostMapping
    public boolean getJsonDataContainer(@RequestBody DataContainer dataContainer) {
        return this.mailerService.sendEmail(dataContainer);
    }

}
