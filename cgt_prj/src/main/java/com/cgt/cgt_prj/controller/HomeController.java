package com.cgt.cgt_prj.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        return "main";
    }
}
