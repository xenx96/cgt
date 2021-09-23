package com.cgt.cgt_prj.user;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class Insert {

    private UserService userService;

    @Autowired
    public Insert(UserService userService){
        this.userService = userService;
    }

    @Test
    public void userFindTest(){
        System.out.println("ID중복조회 메서드 1차 Test입니다. ID = admin1234");
        String id1 = "admin1234";
        userService.idCheck(id1);

        System.out.println("ID중복조회 메서드 2차 Test입니다. ID = IDXXXXXX");
        String id2 = "IDXXXXXXX";
        userService.idCheck(id2);

        System.out.println("ID중복조회 메서드 3차 Test입니다. ID = blank");
        String id3 = "";
        userService.idCheck(id3);
    }

    @Test
    public void userInsert(){

        System.out.println("UserInsert Test 입니다. ID는 없는 ID입니다.");
        UserDTO user2 = new UserDTO();
        user2.set_id("testing1");
        user2.setPW("asdf1234");
        userService.insertUser(user2);
    }

}
