package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.service.LoginService;
import com.cgt.cgt_prj.domain.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

//Login 관련 API.
@RestController
public class LoginApiController {

    @Resource(name = "loginService")
    private LoginService loginService;

    @PostMapping("/api/login")
    public String loginUser(@RequestBody /*@Valid*/ UserDTO userDTO){
        //JWT 생성 부문
        return loginService.userLogin(userDTO);
    }
}
