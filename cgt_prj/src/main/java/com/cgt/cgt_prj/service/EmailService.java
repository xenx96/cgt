package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.repositories.UserRepository;
import java.util.Random;
import lombok.RequiredArgsConstructor;
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
    public Boolean eMailCheck(String EA) {
        return userRepository.findByEA(EA) == null;
    }

    //AuthKey 생성
    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 6자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    @Async
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        javaMailSender.send(simpleMailMessage);
    }

    public void emailForm(String EA, String key) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(EA);
        mailMessage.setSubject("회원가입 이메일 인증");
        mailMessage.setText("인증키는" + key + "입니다. 3분이내로 입력을 완료해주세요.");
        sendEmail(mailMessage);
    }

}