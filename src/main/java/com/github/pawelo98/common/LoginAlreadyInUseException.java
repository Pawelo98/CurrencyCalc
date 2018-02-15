package com.github.pawelo98.common;

public class LoginAlreadyInUseException extends RuntimeException {

    public String login;

    public LoginAlreadyInUseException(String login){
        super(String.format("Email %s is already in use", login));
        this.login = login;
    }
}
