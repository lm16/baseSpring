package com.lm16.uo.controller;

import com.lm16.uo.bean.User;
import com.lm16.uo.config.exception.BaseException;
import com.lm16.uo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("list", userService.findAll());

        return "user";
    }

    @GetMapping("/err")
    public String err(Model model){

        model.addAttribute("list", userService.findAll());

        throw new BaseException("something error");
    }

    @GetMapping("/retry")
    public String retry(Model model){
        User user = userService.findByNameAndPasswordRetry("a", "b");

        model.addAttribute("user", user);

        return "success";
    }

}
