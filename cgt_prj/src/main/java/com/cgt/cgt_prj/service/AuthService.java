package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {

    @Autowired
    UserRepository userRepository;

    // 로그인 로직
    public Boolean userLogin(UserDTO loginUser){
        JSONObject userData= userRepository.findBy_id(loginUser.get_id());
        if (userData == null) {
            return false;
        }
        else{
            Boolean resultPasswordCheck = passwordCheck(loginUser.getPW(), (String) userData.get("PW"));
            return resultPasswordCheck;
        }
    }

    //비밀번호 확인 로직
    public Boolean passwordCheck(String loginPassword,String savedPassword){
        if(loginPassword == savedPassword) return true ;
        else return false;
    }

    public JSONObject jsonWebTokenMake(JSONObject jwt){
        return jwt;
    }
}
