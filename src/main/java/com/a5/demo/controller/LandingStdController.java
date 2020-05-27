package com.a5.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tim Shi
 * @version 1.0
 */
public class LandingStdController {

    @GetMapping("/landingStd")
    public String index(ModelAndView modelAndView) {
        return "landingStd";
    }
}
