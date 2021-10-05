package com.cgt.cgt_prj.controller;


import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Exception deleteUser(@RequestBody UserDTO user) {
        userService.deleteUser(user);
        return null;
    }

    @PutMapping("api/user")
    public void updateUser(@RequestBody UserDTO form) {
        userService.userUpdate(form);
    }


    @GetMapping("api/user/nickname={NN}")
    public boolean checkNickName(@PathVariable String NN) {
        return userService.nNCheck(NN);
    }

}
