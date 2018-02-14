package com.github.pawelo98.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDTOMapper {

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setUuid(user.getPassword());
        return userDTO;
    }

    public static List<UserDTO> toUserDTO(Collection<User> users){
        List<UserDTO> result = new ArrayList<>();
        for(User user : users){
            result.add(toUserDTO(user));
        }
        return result;
    }
}
