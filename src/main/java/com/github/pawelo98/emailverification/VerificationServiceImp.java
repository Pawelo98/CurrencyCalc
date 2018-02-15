package com.github.pawelo98.emailverification;

import com.github.pawelo98.security.User;
import com.github.pawelo98.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VerificationServiceImp implements VerificationService {

    private VerificationRepository verificationRepository;
    private UserRepository userRepository;

    private JavaMailSender javaMailSender;

    @Autowired
    public VerificationServiceImp(VerificationRepository verificationRepository, UserRepository userRepository, JavaMailSender javaMailSender) {
        this.verificationRepository = verificationRepository;
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void verifyToken(String token){
        verificationRepository.findOneByToken(token)
                .ifPresent(t->{
                    if(t.getExpiryDate().isAfter(LocalDateTime.now()))
                    t.getUser().enable();
                    userRepository.save(t.getUser());
                });
    }

    private void sendMail(String email, String token) throws MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo(email);
        helper.setSubject("Potwierdź email");
        helper.setText("http://localhost:8080/api/verification-token/ " + token, false);
        javaMailSender.send(mail);
    }

    @Override
    public void createToken(User user) throws MessagingException{
        VerificationToken token = new VerificationToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(LocalDateTime.now().plusMinutes(2000));
        verificationRepository.save(token);

        sendMail(user.getEmail(),token.getToken());
    }

    @Override
    public VerificationToken findToken(Long id){
        return verificationRepository.findOne(id);
    }
}
