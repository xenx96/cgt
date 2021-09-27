package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;



    //이메일
    public Boolean  nNCheck(String NN){return userRepository.findByNN(NN) == null; }

    @Async
    public void sendEmail(SimpleMailMessage simpleMailMessage){
        javaMailSender.send(simpleMailMessage);
    }

}
