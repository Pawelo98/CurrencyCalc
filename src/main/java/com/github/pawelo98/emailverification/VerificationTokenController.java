package com.github.pawelo98.emailverification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/verification-token")
public class VerificationTokenController {

    private VerificationService verificationService;

    @Autowired
    public VerificationTokenController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("/{token}")
    public void verify(@PathVariable String token) {
        verificationService.verifyToken(token);
    }

    @GetMapping
    public VerificationToken findTokenById(@RequestParam Long id) {
        return verificationService.findToken(id);
    }
}
