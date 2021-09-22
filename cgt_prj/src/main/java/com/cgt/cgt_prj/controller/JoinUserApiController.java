package com.cgt.cgt_prj.controller;




import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.UserService;
import com.cgt.cgt_prj.repositories.UserRepository;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


//Static에 있는 index.html === /하나만 붙인것과 동일하다.
// http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..
//User 관련 API

@RestController
public class JoinUserApiController {


    @Resource(name = "userService")
    private UserService userService;

   //최종 회원가입.
    @PostMapping("/api/user")
    public Boolean registerUser(@RequestBody UserDTO form){
        //UserDTO.UserDTO에 있는 입력값대로 Post로 받아온 RequestBody Data로 검증한다.(@Valid)어노테이션 사용.
        userService.joinId(form);
        return true;
    }

    //ID 중복 체크 매핑
    @GetMapping("api/user")
    public Boolean checkUserId(@RequestParam("id") String id){
        return userService.registerIdCheck(id);
    }



}
