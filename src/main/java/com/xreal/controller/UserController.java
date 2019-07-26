package com.xreal.controller;


import com.xreal.entity.User;
import com.xreal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("id/{id}")
    public @ResponseBody String getUser(@PathVariable String id) {
        User user = userService.getById(Long.valueOf(id));
        if(user!=null){
        return "Hello" + user.getUsername();}
        else {
            return "找不到这个id!";
        }
    }
}
