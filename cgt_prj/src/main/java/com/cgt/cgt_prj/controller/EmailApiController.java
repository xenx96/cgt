package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
public class EmailApiController {

    private final EmailService emailService;


    @GetMapping("api/email")
    public String emailAuth(String EA) {
        if (emailService.eMailCheck(EA)) {
            return null;
        } else {
            String authKey = EmailService.createKey();

            return emailService.eMailJWT(authKey);

        }
    }

}
