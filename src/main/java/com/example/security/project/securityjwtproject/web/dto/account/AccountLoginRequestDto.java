package com.example.security.project.securityjwtproject.web.dto.account;

import lombok.Getter;

@Getter
public class AccountLoginRequestDto {
    private String email;
    private String password;
}
