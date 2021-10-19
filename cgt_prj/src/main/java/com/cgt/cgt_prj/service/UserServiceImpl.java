package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//User에 관한 비즈니스로직 짜는 부분
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    //아이디 조회
    @Override
    public Boolean idCheck(String id) {
        return findBy_id(id) == null;
    }

    //닉네임
    @Override
    public Boolean nNCheck(String NN) {
        return userRepository.findByNN(NN) == null;
    }

    //회원 가입
    @Override
    public void insertUser(UserDTO userDTO) {
        String hashPassword = hashEncodePassword(userDTO.getPW());
        userDTO.setPW(hashPassword);
        userRepository.insert(userDTO);
    }

    // 회원 탈퇴
    @Override
    public void deleteUser(UserDTO user) {
        UserDTO userData = findBy_id(user.get_id());
        if (userData != null && hashedMatch(user.getPW(), userData.getPW())) {
            deleteBy_id(user.get_id());
            System.out.println("Delete User Complete");
        } else {
            System.out.println("Delete User Failed");
        }
        //
    }

    //PW 매치 로직
    @Override
    public boolean hashedMatch(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    //PW 암호화 메서드
    @Override
    public String hashEncodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    //findBy_id method 생성
    @Override
    public UserDTO findBy_id(String id) {
        return userRepository.findBy_id(id);
    }

    //user 정보 삭제 method
    @Override
    @Transactional
    public void deleteBy_id(String id) {
        userRepository.deleteById(id);
    }

    //user 정보 등록 method
    @Override
    @Transactional
    public void userInsert(UserDTO user) {
        userRepository.insert(user);
    }

    //user 정보 삭제 method
    @Override
    @Transactional
    public void userUpdate(UserDTO user) {

        UserDTO userData = findBy_id(user.get_id());
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
