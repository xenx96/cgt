package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.service.EmailServiceImpl;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RequiredArgsConstructor
@RestController
public class EmailApiController {

    private final EmailServiceImpl emailService;


    @PostMapping("api/email")
    public void emailSendAuth(@RequestBody JSONObject eMailAddress) throws Exception {
        String EA = eMailAddress.get("EA").toString();
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARD-FOR");
        emailService.emailCertificate(EA, ip);
    }

    @GetMapping("api/email")
    public Boolean emailCheck(@RequestParam("EA") String EA) {
        return emailService.eMailCheck(EA);
    }

    @GetMapping("api/email/certification")
    public Boolean emailAuthCheck(@RequestParam("EA") String EA ,@RequestParam("num") Long num){

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARD-FOR");
        return emailService.authNumCheck(EA,ip,num);

    }

}
