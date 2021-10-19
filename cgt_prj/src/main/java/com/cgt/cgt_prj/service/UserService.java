package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    //아이디 조회
    public abstract Boolean idCheck(String id);

    //닉네임
    public abstract Boolean nNCheck(String NN);

    //회원 가입
    public abstract void insertUser(UserDTO userDTO);

    // 회원 탈퇴
    public abstract void deleteUser(UserDTO user) ;

    //PW 매치 로직
    public abstract boolean hashedMatch(String password, String hashedPassword);

    //PW 암호화 메서드
    public abstract String hashEncodePassword(String password);


    //findBy_id method 생성
    public abstract UserDTO findBy_id(String id) ;

    //user 정보 삭제 method
    public abstract void deleteBy_id(String id);

    //user 정보 등록 method
    public abstract void userInsert(UserDTO user);

    //user 정보 삭제 method
    public abstract void userUpdate(UserDTO user);

}
