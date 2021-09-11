package com.cgt.cgt_prj.domain;

import com.cgt.cgt_prj.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.bson.json.JsonObject;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;


//User에 관한 비즈니스로직 짜는 부분
public class UserService {
     UserRepository userRepository;




   //PW 암호화 메서드
    public String passwordEncodeSave(String pw){
        String encodingPassword = (pw); //Encoding Method Bycrpt
        return encodingPassword;
    }





}
