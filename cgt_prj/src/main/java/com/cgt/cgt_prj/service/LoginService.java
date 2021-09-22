package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Date;

@Service
public class LoginService {

    @Resource(name = "userService")
    private UserService userService;

    // 로그인 로직
    public String userLogin(UserDTO loginUser){
        JSONObject userData = userService.findBy_id(loginUser.get_id());

        System.out.println(passwordMatch(loginUser.getPW(), (String) userData.get("PW")));
        System.out.println("비밀번호 확인은 위에서");

        if(userData != null && passwordMatch(loginUser.getPW(), (String) userData.get("PW"))) {
            userData.putAll(userService.findBy_id(loginUser.get_id()));
            return jsonWebTokenMake(userData);
        }
        else{
            System.out.println("failed");
            return "failed";
        }
    }

    //비밀번호 매치 로직
    public boolean passwordMatch(String password, String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }
    //JWT 생성 로직.
    public String jsonWebTokenMake(JSONObject form){

        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE)// Select Header Type
                .setIssuer("CGT") //Who is the Maker?
                .setIssuedAt(now)// when is created at?
                .setExpiration(new Date(now.getTime() + Duration.ofHours(2).toMillis())) // when is expired time?
                .claim("id",form.get("id")) // add clime; like key:value.
                .claim("email", form.get("EA"))// if you want to add, Add .claim().
                .signWith(SignatureAlgorithm.HS512,"secret")// Hashed Algorithm & Secret Key
                .compact(); //Making.
    }
}
