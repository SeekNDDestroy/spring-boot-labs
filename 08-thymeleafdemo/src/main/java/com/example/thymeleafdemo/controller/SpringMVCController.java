package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class SpringMVCController {


    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("date", java.time.LocalDateTime.now());
        return "helloworld";
    }
}
