package com.cgt.cgt_prj.user;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.UserService;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Insert {

    private final UserService userService;
    @Autowired
    public Insert(UserService userService) {
        this.userService = userService;

    }

    @Test
    public void userFindTest() {
        System.out.println("ID중복조회 메서드 1차 Test입니다. ID = admin1234");
        String id1 = "admin1234";
        System.out.println(userService.idCheck(id1));

        System.out.println("ID중복조회 메서드 2차 Test입니다. ID = IDXXXXXX");
        String id2 = "IDXXXXXXX";
        userService.idCheck(id2);
        System.out.println(userService.idCheck(id2));

        System.out.println("ID중복조회 메서드 3차 Test입니다. ID = blank");
        String id3 = "";
        userService.idCheck(id3);
        System.out.println(userService.idCheck(id3));
    }

    @Test
    public void userInfoTest() {

        //<-- First Test -->
        System.out.println("UserInsert Test 입니다. ID는 testing123 입니다.");
        String id = "testing123";
        String PW = "asdf1234";
        String NM = "이름";
        String MN = "번호";
        Number SX = 1;
        String EA = "EA";
        String ADR = "ADR";
        Date CA = new Date();
        Date BT = new Date();
        UserDTO user1;
        user1 = new UserDTO(id,PW,NM,MN,SX,EA,ADR,CA,BT);
        user1.set_id("testing123");
        user1.setPW("asdf1234");
        userService.insertUser(user1);
        System.out.println("Insert 완료");

        System.out.println("UserUpdate Test입니다. ID는 testing123입니다.");

        String PW2= "aaaa1234";
        String MN2 = "010-2222-2222";
        user1.setPW(PW2);
        user1.setMN(MN2);
        userService.userUpdate(user1);
        System.out.println(userService.findBy_id(user1.get_id()));
        System.out.println("Update 완료.");

        System.out.println("UserDelete Test 입니다. ID는 testing123입니다.");
        userService.deleteUser(user1);
        System.out.println("Delete 완료.");
    }


}
