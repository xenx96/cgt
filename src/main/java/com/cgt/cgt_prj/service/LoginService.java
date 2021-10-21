package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.UserDTO;

public interface LoginService {

    public abstract String userLogin(UserDTO loginUser);
    //JWT 생성 로직.
    public abstract String JWTMake(UserDTO form);
}
