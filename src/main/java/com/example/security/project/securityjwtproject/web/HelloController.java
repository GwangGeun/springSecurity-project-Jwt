package com.example.security.project.securityjwtproject.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/v1")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/v2")
    public String hello2(){
        return "hello2";
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

}
