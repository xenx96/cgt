package com.cgt.cgt_prj.service;


import org.springframework.mail.SimpleMailMessage;

public interface EmailService {


    //이메일
    public abstract Boolean eMailCheck(String EA) ;
    public abstract void emailSend(String EA, String key);
    public abstract SimpleMailMessage emailSet(String EA, String key);
    public abstract Boolean emailCertificate(String EA, String ip) throws Exception;
    public abstract Boolean authNumCheck(String EA,String ip, Long num);



}
