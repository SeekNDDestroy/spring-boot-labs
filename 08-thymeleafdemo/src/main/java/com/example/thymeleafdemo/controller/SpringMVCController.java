package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class SpringMVCController {

    @GetMapping("/page")
    public String showPage(Model model){
        model.addAttribute("name", "eren");
        return "page";
    }

    // shows a page with param.values (taken directly from the template not sent to the backend)
    @GetMapping("/onSubmit")
    public String showProcessedForm(){
        return "confirmation";
    }

    @GetMapping("/onSubmitOne")
    public String showProcessedFormOne(HttpServletRequest httpServletRequest, Model model){
        String firstName = httpServletRequest.getParameter("firstName");
        String lastName = httpServletRequest.getParameter("lastName");
        String age = httpServletRequest.getParameter("age");

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("age", age);

        return "confirmationOne";
    }

    @GetMapping("/onSubmitTwo")
    public String showProcessedFormThree(@RequestParam String firstName,
                                         @RequestParam String lastName,
                                         @RequestParam String age,
                                         Model model){

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("age", age);
        return "confirmationTwo";
    }


}