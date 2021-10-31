package com.cgt.cgt_prj.user;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.LoginServiceImpl;
import com.cgt.cgt_prj.service.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class Login {

    private LoginServiceImpl loginServiceImpl;

    @Autowired
    public Login(UserServiceImpl userService, LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }

    @Test
    public void testJWT() {

        System.out.println("JWT생성 Test 입니다.");
        String id = "testing123";
        String PW = "asdf1234";
        String NM = "이름";
        String MN = "번호";
        Number SX = 1;
        String EA = "EA";
        String ADR = "ADR";
        Date CA = new Date();
        Date BT = new Date();
        UserDTO user1;
        user1 = new UserDTO(id,PW,NM,MN,SX,EA,ADR,CA,BT);
        String token = loginServiceImpl.JWTMake(user1);

        System.out.println(Jwts.parser()
            .setSigningKey("secret")
            .parseClaimsJws(token)
            .getBody());
    }

    @Test
    public void testLogin() {

        System.out.println("Login 1차 테스트입니다.");
        String id = "testing123";
        String PW = "Errrorrrrr";
        String NM = "이름";
        String MN = "번호";
        Number SX = 1;
        String EA = "EA";
        String ADR = "ADR";
        Date CA = new Date();
        Date BT = new Date();
        UserDTO user1;
        user1 = new UserDTO(id,PW,NM,MN,SX,EA,ADR,CA,BT);
        String loginTest2 = loginServiceImpl.userLogin(user1);
        System.out.println(loginTest2);

        System.out.println("Login 2차 테스트입니다.");
        String id1 = "testing123";
        String PW1 = "asdf1234";
        String NM1 = "이름";
        String MN1 = "번호";
        Number SX1 = 1;
        String EA1 = "EA";
        String ADR1 = "ADR";
        Date CA1 = new Date();
        Date BT1 = new Date();
        UserDTO user2;
        user2 = new UserDTO(id1,PW1,NM1,MN1,SX1,EA1,ADR1,CA1,BT1);
        String loginTest3 = loginServiceImpl.userLogin(user2);
        System.out.println(loginTest3);


    }
}
