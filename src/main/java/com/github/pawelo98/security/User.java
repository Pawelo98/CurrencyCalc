package com.github.pawelo98.security;

import com.github.pawelo98.common.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@Entity
public class User extends BaseEntity implements UserDetails{

    @Size(min=1, max=50)
    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    private boolean isEnabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.emptySet();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public boolean getEnabled() {return isEnabled; }

    public void setEnabled(boolean isEnabled) {this.isEnabled = true; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void enable(){
        this.isEnabled = true;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return isEnabled;
    }
}
