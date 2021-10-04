package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


//User에 관한 비즈니스로직 짜는 부분
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    //아이디 조회
    public Boolean idCheck(String id) {
        return findByID(id) == null;
    }

    //닉네임
    public Boolean nNCheck(String NN) {
        return userRepository.findByNN(NN) == null;
    }

    //회원 가입
    public void insertUser(UserDTO userDTO) {
        String hashPassword = hashEncodePassword(userDTO.getPW());
        userDTO.setPW(hashPassword);
        userInsert(userDTO);
    }

    // 회원 탈퇴
    public void deleteUser(UserDTO user) {
        //PW 검증
        UserDTO userData = findByID(user.getID());
        if (userData != null && hashedMatch(user.getPW(), userData.getPW())) {
            deleteByID(user.getID());
            System.out.println("Delete User Complete");
        } else {
            System.out.println("Delete User Failed");
        }
        //
    }

    //PW 매치 로직
    public boolean hashedMatch(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    //PW 암호화 메서드
    public String hashEncodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    //findByID method 생성
    public UserDTO findByID(String id) {
        return userRepository.findByID(id);
    }

    //user 정보 삭제 method
    @Transactional
    public void deleteByID(String id) {
        userRepository.deleteByID(id);
    }

    //user 정보 등록 method
    @Transactional
    public void userInsert(UserDTO user) {
        userRepository.insert(user);
    }

    @Transactional
    public void userUpdate(UserDTO user) {
        UserDTO userData = findByID(user.getID());
        //수정가능 인자 PW/MN/ADR/BT/UA
        Date now = new Date();
        userData.setPW(hashEncodePassword(
                user.getPW()
        ));
        userData.setMN(user.getMN());
        userData.setADR(user.getADR());
        userData.setBT(user.getBT());
        userData.setUA(now);
        userRepository.save(userData);
    }
}
