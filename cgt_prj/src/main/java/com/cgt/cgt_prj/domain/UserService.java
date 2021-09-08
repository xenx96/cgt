package com.cgt.cgt_prj.domain;

import com.cgt.cgt_prj.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.bson.json.JsonObject;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;


//User에 관한 비즈니스로직 짜는 부분
public class UserService {
     UserRepository userRepository;


    //ID 중복체크 메서드
    public String checkId(String id){
        System.out.println(id);
        JSONObject check = userRepository.findBy_id(id);
        if (check != null) return "사용할 수 없습니다.";
        else return "사용 가능합니다.";
    }

   //PW 암호화 메서드
    public String passwordEncodeSave(String pw){
        String encodingPassword = (pw); //Encoding Method Bycrpt
        return encodingPassword;
    }





}
