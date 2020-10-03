package com.example.security.project.securityjwtproject.config.security;

import com.example.security.project.securityjwtproject.domain.entity.Account;
import com.example.security.project.securityjwtproject.domain.repository.AccountRepository;
import com.example.security.project.securityjwtproject.exception.CustomException;
import com.example.security.project.securityjwtproject.exception.CustomExceptionErrorList;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("NOT_EXIST_ACCOUNT"));
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(account.getEmail(),account.getPassword(), authorityListUser);
    }
}
