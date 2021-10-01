package com.cgt.cgt_prj.user;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class Insert {

    private UserService userService;

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
        UserDTO user1 = new UserDTO();
        user1.set_id("testing123");
        user1.setPW("asdf1234");
        userService.insertUser(user1);
        System.out.println("Insert 완료");

        System.out.println("UserUpdate Test입니다. ID는 testing123입니다.");
        UserDTO user2 = new UserDTO();
        user2.set_id("testing123");
        user2.setPW("aaaa1234");
        user2.setMN("010-2222-2222");
        userService.userUpdate(user2);
        System.out.println(userService.findBy_id(user2.get_id()));
        System.out.println("Update 완료.");

        System.out.println("UserDelete Test 입니다. ID는 testing123입니다.");
        UserDTO user3 = new UserDTO();
        user3.set_id("testing123");
        user3.setPW("aaaa1234");
        userService.deleteUser(user3);
        System.out.println("Delete 완료.");
    }


}
