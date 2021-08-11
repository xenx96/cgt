package com.cgt.cgt_prj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//Static에 있는 index.html === /하나만 붙인것과 동일하다.
// http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..

@RestController
public class HomeController {
    
    //index Web Page
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexView(){
        return "index2";
    }

    //Main Web Page
    @RequestMapping("/main")
    public ModelAndView mainView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view/main"); //ViewFile = main.html
        mav.addObject("data", "YDS"); //addObject로  data 송신이 가능하다.
        return mav;
    }
    //etc,,

}
