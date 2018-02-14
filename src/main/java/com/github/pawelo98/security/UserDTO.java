package com.github.pawelo98.security;

import com.github.pawelo98.common.BaseEntity;

import java.util.UUID;

public class UserDTO extends BaseEntity{

    private String uuid = UUID.randomUUID().toString();;
    private String email;

    public String getEmail() {
        return email;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
