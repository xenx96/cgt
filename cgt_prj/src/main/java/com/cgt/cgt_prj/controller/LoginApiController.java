package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.service.AuthService;
import com.cgt.cgt_prj.domain.UserDTO;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;

//Login 관련 API.
public class LoginApiController {

    @Resource(name = "authService")
    private AuthService authService ;

    @PostMapping("/api/login")
    public JSONObject loginUser(@RequestBody @Valid UserDTO userDTO){
        //ID Check & PW Check
        JSONObject resultUserjwt = authService.userLogin(userDTO);

        //JWT 생성 부문
        return resultUserjwt ;

    }
}
