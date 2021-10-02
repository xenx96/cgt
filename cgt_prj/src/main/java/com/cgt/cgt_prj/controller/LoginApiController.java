package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.LoginService;
import javax.annotation.Resource;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Login 관련 API.
@RestController
@RequiredArgsConstructor
public class LoginApiController {

    private final LoginService loginService;


    @PostMapping("/api/login")
    public String loginUser(@RequestBody /*@Valid*/ UserDTO userDTO) {
        //JWT 생성 부문
        return loginService.userLogin(userDTO);
    }
}
