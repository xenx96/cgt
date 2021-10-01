package com.cgt.cgt_prj.controller;


import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.EmailService;
import com.cgt.cgt_prj.service.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Jwts;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Static에 있는 index.html === /하나만 붙인것과 동일하다.
// http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..
//User 관련 API

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    //최종 회원가입.
    @PostMapping("/api/user")
    public Boolean registerUser(@RequestBody UserDTO form) {
        //UserDTO.UserDTO에 있는 입력값대로 Post로 받아온 RequestBody Data로 검증한다.(@Valid)어노테이션 사용.
        userService.insertUser(form);
        return true;
    }

    //ID 중복 체크 매핑
    @GetMapping("api/user")
    public Boolean checkUserId(@RequestParam("id") String id) {
        return userService.idCheck(id);
    }

    //회원 탈퇴 Mapping
    @DeleteMapping("api/user")
    public Exception deleteUser(@RequestHeader String JWT) throws Exception {
        String id = (String) Jwts.parser()
            .setSigningKey("secret")
            .parseClaimsJws(JWT)
            .getBody().get("id");

        userService.deleteBy_id(id);
        return null;
    }

    @PutMapping("api/user")
    public void updateUser(@RequestBody UserDTO form) throws JsonProcessingException {
        userService.userUpdate(form);
    }


    @GetMapping("api/user/nickname={NN}")
    public boolean checkNickName(@PathVariable String NN) {
        return userService.nNCheck(NN);
    }

}
