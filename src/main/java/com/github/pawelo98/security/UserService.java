package com.github.pawelo98.security;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    public void addUser(String email, String password) throws MessagingException;
    public List<UserDTO> showUsers();
}
