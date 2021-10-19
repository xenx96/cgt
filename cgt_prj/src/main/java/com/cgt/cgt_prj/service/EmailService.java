package com.cgt.cgt_prj.service;


public interface EmailService {


    //이메일
    public abstract Boolean eMailCheck(String EA) ;
    public abstract void emailSend(String EA, String key);
    public abstract void emailCertificate(String EA, String ip);
    public abstract Boolean authNumCheck(String EA,String ip, Long num);



}
