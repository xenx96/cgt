package com.cgt.cgt_prj.user;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.LoginService;
import com.cgt.cgt_prj.service.UserService;
import io.jsonwebtoken.Jwts;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Login {

    private LoginService loginService;

    @Autowired
    public Login(UserService userService, LoginService loginService) {
        this.loginService = loginService;
    }

    @Test
    public void testJWT() {

        System.out.println("JWT생성 Test 입니다.");
        UserDTO form = new UserDTO();
        form.set_id("admin");
        form.setEA("admin@naver.com");
        String token = loginService.JWTMake(form);

        System.out.println(Jwts.parser()
            .setSigningKey("secret")
            .parseClaimsJws(token)
            .getBody());
    }

    @Test
    public void testLogin() {

        System.out.println("Login 1차 테스트입니다.");
        UserDTO user2 = new UserDTO();
        user2.set_id("admin1234");
        user2.setPW("asdf1234");
        String loginTest2 = loginService.userLogin(user2);
        System.out.println(loginTest2);

        System.out.println("Login 2차 테스트입니다.");
        UserDTO user3 = new UserDTO();
        user3.set_id("xenx96");
        user2.setPW("ydsm1738");
        String loginTest3 = loginService.userLogin(user3);
        System.out.println(loginTest3);


    }
}
