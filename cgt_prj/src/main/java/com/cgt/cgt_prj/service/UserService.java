package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;


//User에 관한 비즈니스로직 짜는 부분
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //아이디 조회
     public Boolean registerIdCheck(String id){
         if(userRepository.findBy_id(id) != null) { //null이 아닐경우, 아이디가 존재함으로 false 리턴
             return  false;
         } else { //null 이면, 아이디가 존재하지 않음으로, 사용가능 true 반환.
             return true;
         }
     }

   //PW 암호화 메서드
    public String passwordEncodeSave(String pw){
        String encodingPassword = (pw); //Encoding Method Bycrpt
        return encodingPassword;
    }





}
