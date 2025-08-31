package com.lab.quick.start.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {


    @GetMapping("/home")
    public String home(){
        return "<h1> welcome home </h1>";
    }
}
