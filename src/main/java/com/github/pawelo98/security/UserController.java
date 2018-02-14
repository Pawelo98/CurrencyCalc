package com.github.pawelo98.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/new")
    public UserDTO userDTO(@RequestParam String email,@RequestParam String password) {
        return userService.addUser(email, password);
    }
}
