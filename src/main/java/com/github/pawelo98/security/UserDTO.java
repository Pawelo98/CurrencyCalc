package com.github.pawelo98.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pawelo98.common.BaseEntity;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO extends BaseEntity{

    private String uuid = UUID.randomUUID().toString();
    private String email;

    public String getEmail() {
        return email;
    }

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
