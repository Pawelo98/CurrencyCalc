package com.github.pawelo98.security;

import com.github.pawelo98.common.LoginAlreadyInUseException;
import com.github.pawelo98.emailverification.VerificationService;
import com.github.pawelo98.emailverification.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.github.pawelo98.security.UserDTOMapper.toUserDTO;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationService verificationService;

    public void addUser(String email, String password) throws MessagingException{

        if(userRepository.existsByEmail(email)){
            throw new LoginAlreadyInUseException(email);
        }
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));

            user = userRepository.save(user);

            verificationService.createToken(user);

            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, Collections.emptySet());
            ctx.setAuthentication(auth);
    }

    public List<UserDTO> showUsers(){
        return toUserDTO(userRepository.findAll());
    }

}
