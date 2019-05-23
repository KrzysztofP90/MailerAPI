package com.krzysztof.MailerAPI;

import com.krzysztof.MailerAPI.model.DataContainer;
import com.krzysztof.MailerAPI.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getJsonDataContainer(@RequestBody DataContainer dataContainer) {
        if (dataContainer.getEmailPassword() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        boolean status = mailerService.sendEmail(dataContainer);
        if (status) {
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        return new ResponseEntity<>(status, HttpStatus.FORBIDDEN);
    }

}
