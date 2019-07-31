package com.xreal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PageController {

    @RequestMapping("/")
    public String sayHello() {
        return "indexbak";
    }

    @RequestMapping("/indexvue")
    public String getVue() {
        return "indexvue";
    }

    @RequestMapping("/index")
    public String getIce() {
        return "index";
    }

    @RequestMapping("/demo")
    public String myDemo(Model model) {
        return "demo";
    }

    @RequestMapping("/view")
    public String myView() {
        return "view";
    }
}