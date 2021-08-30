package com.cgt.cgt_prj.controller;


import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.minidev.json.JSONArray;

//Static에 있는 index.html === /하나만 붙인것과 동일하다.
// http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..

@RestController
public class HomeController{

    @Autowired
    UserRepository userRepository;

   @RequestMapping("/")
   public String Test(){
       return "test";
   }

   @PostMapping("api/join")
   public ModelAndView joinUser(
       //@RequestParam(value = "ID", required = false)String _id,
       //@RequestParam(value = "PW", required = false)String PW,
       //@RequestParam(value = "NM", required = false)String NM,
       //@RequestParam(value = "EA", required = false)String EA,
       //@RequestParam(value = "MN", required = false)Number MN,
       //@RequestParam(value = "SX", required = false)Number SX,
       //@RequestParam(value = "ADR", required = false)String ADR,
       //@RequestParam(value= "CA",required = false) String CA,
       @RequestBody Object userfrm

   ){
       //RequestParam 으로 파라미터들 Post Sending 된것들 받아오기.
       //DB에서 바로 Save하기.
       //id 및 EA 중복여부는 Ajax로 프론트End에서 처리한다.

       //UserDTO userdata = new UserDTO(_id, PW, NM, EA, MN, SX, ADR, CA);
        //userRepository.save(userdata); 
        System.out.println(userfrm);      
    return new ModelAndView("redirect:/join");
       
   }


}
