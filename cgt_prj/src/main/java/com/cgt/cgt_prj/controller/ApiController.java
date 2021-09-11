package com.cgt.cgt_prj.controller;




import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.domain.UserService;
import com.cgt.cgt_prj.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


//Static에 있는 index.html === /하나만 붙인것과 동일하다.
// http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..

@RestController
public class ApiController {

    @Autowired
    UserRepository userRepository;
    UserService userService ;

   //최종 회원가입.
    @PostMapping("/api/user")
    public String registerUser(@RequestBody @Valid UserDTO form
                               //UserDTO.UserDTO에 있는 입력값대로 Post로 받아온 RequestBody Data로 검증한다.(@Valid)어노테이션 사용.
    ){
        System.out.println(form);
           userRepository.insert(form);

        return null;

    }


    //ID 중복 체크 매핑
    @GetMapping("api/user")
    public Boolean checkUserId(@RequestParam("id") String id
                              //UserDTO.UserDTO에 있는 입력값대로 Post로 받아온 RequestBody Data로 검증한다.(@Valid)어노테이션 사용.
    ){
        System.out.println(userRepository.findBy_id(id));
        if(userRepository.findBy_id(id) != null) {
            System.out.println(false);
            return  false;
        } else {
            System.out.println(true);
            return true;
        }
        //return true;
    }


}
