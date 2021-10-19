package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.LoginServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Login 관련 API.
@RestController
@RequiredArgsConstructor
public class LoginApiController {

    private final LoginServiceImpl loginServiceImpl;


    @PostMapping("/api/login")
    public String loginUser(@RequestBody /*@Valid*/ UserDTO userDTO) {
        //JWT 생성 부문
        return loginServiceImpl.userLogin(userDTO);
    }
}
