package com.github.pawelo98.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/hello")
    public String hello(){
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Hi " + auth.getName() + "!";
    }
}
