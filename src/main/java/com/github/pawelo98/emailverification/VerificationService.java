package com.github.pawelo98.emailverification;

import com.github.pawelo98.security.User;

import javax.mail.MessagingException;

public interface VerificationService {

    void verifyToken(String token);
    void createToken(User user) throws MessagingException;
    VerificationToken findToken(Long id);
}
