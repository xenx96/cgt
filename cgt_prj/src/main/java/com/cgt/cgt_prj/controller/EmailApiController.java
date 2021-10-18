package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.service.EmailService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmailApiController {

    private final EmailService emailService;


    @PostMapping("api/email")
    public void emailAuth(@RequestBody JSONObject eMailAddress) {
        String EA = eMailAddress.get("EA").toString();
        emailService.emailService(EA);
    }
    @GetMapping("api/email")
    public Boolean emailCheck(@RequestBody JSONObject eMailAddress) {
        String EA = eMailAddress.get("EA").toString();
        return emailService.eMailCheck(EA);
    }
}
