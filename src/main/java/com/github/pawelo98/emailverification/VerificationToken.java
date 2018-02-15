package com.github.pawelo98.emailverification;

import com.github.pawelo98.common.BaseEntity;
import com.github.pawelo98.security.User;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class VerificationToken extends BaseEntity {

    @OneToOne
    private User user;
    private String token;
    private LocalDateTime expiryDate;

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
