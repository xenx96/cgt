package com.cgt.cgt_prj.controller;




import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


//Static에 있는 index.html === /하나만 붙인것과 동일하다.
//http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..

@RestController
public class HomeController{

    @Autowired
    UserRepository userRepository;

   @RequestMapping("/")
   public String Test(){
       return "test";
   }

   @PostMapping("api/join_check")
   public String Check_id(@RequestBody @Valid UserDTO get_id
		   //UserDTO.UserDTO에 있는 입력값대로 Post로 받아온 RequestBody Data로 검증한다.(@Valid)어노테이션 사용.
	){
        userRepository.insert(get_id);

    return null;
       
   }
    @PostMapping("api/join")
    public String registerUser(@RequestBody @Valid UserDTO userfrm
    		 //UserDTO.UserDTO에 있는 입력값대로 Post로 받아온 RequestBody Data로 검증한다.(@Valid)어노테이션 사용.
    ){
       userRepository.insert(userfrm);

        return null;

    }


}
