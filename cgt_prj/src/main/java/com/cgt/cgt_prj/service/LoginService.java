package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;

    // 로그인 로직
    public String userLogin(UserDTO loginUser) {

        UserDTO userData = userService.findBy_id(loginUser.get_id());
        if (userData != null && userService.hashedMatch(loginUser.getPW(),
            userData.getPW())) {
            return JWTMake(userData);
        } else {
            return "failed";
        }
    }


    //JWT 생성 로직.
    public String JWTMake(UserDTO form) {

        Date now = new Date();
        return Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)// Select Header Type
            .setIssuer("CGT") //Who is the Maker?
            .setIssuedAt(now)// when is created at?
            .setExpiration(
                new Date(now.getTime() + Duration.ofHours(2).toMillis())) // when is expired time?
            .claim("id", form.get_id()) // add clime; like key:value.
            .claim("email", form.getEA())// if you want to add, Add .claim().
            .signWith(SignatureAlgorithm.HS512, "secret")// Hashed Algorithm & Secret Key
            .compact(); //Making.
    }
}
