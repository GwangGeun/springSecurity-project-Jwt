package com.example.security.project.securityjwtproject.web.dto.account;

import lombok.Getter;

@Getter
public class AccountSignUpRequestDto {
    private String email;
    private String password;
    private String name;
    private String gender;
}
