package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

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

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    @Async
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        javaMailSender.send(simpleMailMessage);
    }

    public String eMailJWT(String authKey) {

        Date now = new Date();
        return Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)// Select Header Type
            .setIssuer("CGT") //Who is the Maker?
            .setIssuedAt(now)// when is created at?
            .setExpiration(
                new Date(now.getTime() + Duration.ofMinutes(3).toMillis())) // when is expired time?
            .claim("AuthString", authKey)
            .signWith(SignatureAlgorithm.HS512, "secret")// Hashed Algorithm & Secret Key
            .compact(); //Making.
    }

}
