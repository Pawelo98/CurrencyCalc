package com.github.pawelo98.security;

import static com.github.pawelo98.security.UserDTOMapper.toUserDTO;

public class UserServiceImp implements UserService{

    private UserRepository userRepository;

    public UserDTO addUser(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return toUserDTO(userRepository.save(user));
    }
}
