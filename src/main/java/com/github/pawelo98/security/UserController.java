package com.github.pawelo98.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String email, @RequestParam String password) throws MessagingException{
        userService.addUser(email, password);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/hello");
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/show")
    public List<UserDTO> showAllUsers(){
        return userService.showUsers();
    }
}
