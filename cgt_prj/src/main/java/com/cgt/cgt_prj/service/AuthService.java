package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;

public class AuthService {

    @Autowired
    UserRepository userRepository;
    UserService userService;
    // 로그인 로직
    public String userLogin(UserDTO loginUser){
        Optional<UserDTO> userData = userRepository.findBy_id(loginUser.get_id());
        if (userData == null) {
            return "no Id";
        }
        userData.stream().findAny("PW")
        else{
            if (passwordCheck(loginUser.getPW(), (String) userData.get("PW"))) throw new IllegalArgumentException();
            return jsonWebTokenMake(userData);
        }
    }

    //비밀번호 확인 로직
    public Boolean passwordCheck(String loginPassword,String savedPassword){

        if(userService.passwordMatch(loginPassword,savedPassword)) return true ;
        else return false;
    }

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
