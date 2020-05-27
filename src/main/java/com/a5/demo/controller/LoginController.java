package com.a5.demo.controller;

import com.a5.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String userName = user.getUserName();
        String password = user.getPassword();

        if(!"tim.shi@uoa.com".equals(userName)){
            modelAndView.addObject("error","User Not Found!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if(!"123".equals(password)){
            modelAndView.addObject("error","Password Incorrect!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.addObject("userName",userName);
        modelAndView.setViewName("landingStd");
        return modelAndView;
    }
}
