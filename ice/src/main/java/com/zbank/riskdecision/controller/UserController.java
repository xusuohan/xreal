package com.zbank.riskdecision.controller;


import com.zbank.riskdecision.entity.User;
import com.zbank.riskdecision.service.UserService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
//@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping("/test")
    public @ResponseBody String getTest() {
    	System.out.println("Testing ....");
        return "Hello Test";
    }

    @RequestMapping("/ID/{id}")
    public @ResponseBody String getUser(@PathVariable String id) {
    	System.out.println("111111111111111");
        User user = userService.getById(Integer.valueOf(id));
        System.out.println("rquesting a controlller");
        System.out.println("222222222 " + user);
        return "Hello " + user.getUsername() + ", your email addrss is "+ user.getEmail();
    }
    
    @RequestMapping("/all")
    public @ResponseBody List<Map<Integer,Object>> getALl() {
    	System.out.println("getting all ....");
        return userService.getAllData();
    }
    
    @RequestMapping("/usercount")
    public @ResponseBody List<Map<Integer,Object>> getUserCount() {
    	System.out.println("getting all ....");
        return userService.getCount();
    }
}
