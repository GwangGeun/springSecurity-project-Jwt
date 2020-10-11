package com.example.security.project.securityjwtproject.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello/v1")
    public String hello(){
        log.debug("hello log");
        return "hello";
    }

    @GetMapping("/hello/v2")
    public String hello2(){
        log.debug("hello2 log");
        return "hello2";
    }

    @GetMapping("/ping")
    public String ping(){
        log.error("ping log");
        return "pong";
    }

}
