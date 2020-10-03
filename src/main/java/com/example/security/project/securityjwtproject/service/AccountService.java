package com.example.security.project.securityjwtproject.service;

import com.example.security.project.securityjwtproject.config.security.JwtTokenProvider;
import com.example.security.project.securityjwtproject.domain.entity.Account;
import com.example.security.project.securityjwtproject.domain.repository.AccountRepository;
import com.example.security.project.securityjwtproject.exception.CustomException;
import com.example.security.project.securityjwtproject.exception.CustomExceptionErrorList;
import com.example.security.project.securityjwtproject.web.dto.account.AccountLoginRequestDto;
import com.example.security.project.securityjwtproject.web.dto.account.AccountSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AccountRepository accountRepository;

    public Long signup(AccountSignUpRequestDto accountSignUpRequestDto){
        // 이미 존재하는 유저일 경우, 회원 가입 불가
        Optional<Account> byEmail = accountRepository.findByEmail(accountSignUpRequestDto.getEmail());
        if(byEmail.isPresent()){
            throw new CustomException(CustomExceptionErrorList.DUPLICATE_ACCOUNT);
        }
        return accountRepository.save(Account.builder()
                .email(accountSignUpRequestDto.getEmail())
        .password(passwordEncoder.encode(accountSignUpRequestDto.getPassword()))
        .name(accountSignUpRequestDto.getName())
        .gender(accountSignUpRequestDto.getGender()).build()).getId();
    }


    public String login(AccountLoginRequestDto accountLoginRequestDto){
        Account account = accountRepository.findByEmail(accountLoginRequestDto.getEmail()).orElseThrow(() -> new CustomException(CustomExceptionErrorList.NOT_EXIST_ACCOUNT));
        if (!passwordEncoder.matches(accountLoginRequestDto.getPassword(),account.getPassword())) {
            throw new CustomException(CustomExceptionErrorList.NOT_MATCHED_PASSWORD);
        }
        return jwtTokenProvider.createToken(account.getEmail(), account.getName());
    }
}
