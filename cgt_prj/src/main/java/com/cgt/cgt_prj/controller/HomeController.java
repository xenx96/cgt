package com.cgt.cgt_prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//Static에 있는 index.html === /하나만 붙인것과 동일하다.
// http://~~~/index 와 main에 관하여 아래와같이 설정할 수 있다..
@Controller
public class HomeController {
    @GetMapping("/index")
    public String indexView(Model model){
        return "index";
    }
    @GetMapping("/main")
    public String mainView(Model model){
        model.addAttribute("data", "yds");
        return "view/main";
    }

}
