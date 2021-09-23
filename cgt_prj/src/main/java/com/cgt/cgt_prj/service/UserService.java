package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//User에 관한 비즈니스로직 짜는 부분
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //아이디 조회
     public Boolean idCheck(String id){return findBy_id(id) == null; }
    //
     public void  insertUser(UserDTO userDTO){
        String hashPassword = hashEncodePassword(userDTO.getPW());
        userDTO.setPW(hashPassword);
        userRepository.insert(userDTO);
     }

   //PW 암호화 메서드
    public String hashEncodePassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    //findBy_id method 생성
    public JSONObject findBy_id(String id){
        return userRepository.findBy_id(id);
    }






}
