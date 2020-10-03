package com.example.security.project.securityjwtproject.web;

import com.example.security.project.securityjwtproject.service.AccountService;
import com.example.security.project.securityjwtproject.web.dto.account.AccountLoginRequestDto;
import com.example.security.project.securityjwtproject.web.dto.account.AccountSignUpRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/signup")
    public Long signup(@RequestBody AccountSignUpRequestDto accountSignUpRequestDto){
        return accountService.signup(accountSignUpRequestDto);
    }

    @PostMapping("/login")
    public Response login(@RequestBody AccountLoginRequestDto accountLoginRequestDto){
        String login = accountService.login(accountLoginRequestDto);
        return new Response(login);
    }

    @Getter
    @AllArgsConstructor
    static class Response<V> {
        private V authorization;
    }

}
