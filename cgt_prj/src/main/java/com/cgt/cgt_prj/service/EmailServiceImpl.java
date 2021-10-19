package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.repositories.EmailRepository;
import com.cgt.cgt_prj.repositories.UserRepository;

import com.cgt.cgt_prj.domain.Email;

import java.util.Date;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {


    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;
    private static String Email_Title = "CGT 이메일 인증입니다.";

    //이메일
    @Override
    public Boolean eMailCheck(String EA) {
        return userRepository.findByEA(EA) == null;
    }



    /*
     *After Set the Message, Sending Email.(sendEmail)
     *emailForm is Method of Setting Message
     */
    @Override
    public void emailSend(String EA, String key) {
        SimpleMailMessage mailMessage = emailSet(EA,key);
        javaMailSender.send(mailMessage);
    }
    @Override
    public SimpleMailMessage emailSet(String EA, String key) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(EA);
        mailMessage.setSubject(Email_Title);
        mailMessage.setText("인증키는" + key + "입니다. 3분이내로 입력을 완료해주세요.");
        return mailMessage;
    }

    @Override
    public Boolean authNumCheck(String EA,String ip, Long num){
        Email email = new Email();
        email.setEA(EA);
        email.setNM(ip);
        Email emailData = emailRepository.findOne(email);
        if (emailData == null) return false;
        return emailData.getNum() == num;
    }

    @Override
    @Transactional
    public void emailCertificate(String EA, String ip) throws Exception {
        Email email = new Email();
        String key = createKey();
        email.setCA(new Date());
        email.setEA(EA);
        if (emailRepository.findAllByIp(ip).stream().count()>=3)
            throw new Exception("최근 시도횟수가 많습니다.");

        email.setNum(Long.parseLong(key));
        email.setNM(ip);
        emailRepository.insert(email);
        emailSend(EA, key);
    }
    //AuthKey 생성
    public static String createKey() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 6자리
            key.append((rnd.nextInt(10)));
        }

        return key.toString();
    }
}
