package com.cgt.cgt_prj.service;


import com.cgt.cgt_prj.domain.Email;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {


    //이메일
    public abstract Boolean eMailCheck(String EA) ;
    public abstract void emailSend(String EA, String key);
    public abstract SimpleMailMessage emailSet(String EA, String key);
    public abstract void emailCertificate(String EA, String ip);
    public abstract Boolean authNumCheck(String EA,String ip, Long num);



}
