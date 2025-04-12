package com.example.wc_web.dto.user;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;

    public CreateUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
