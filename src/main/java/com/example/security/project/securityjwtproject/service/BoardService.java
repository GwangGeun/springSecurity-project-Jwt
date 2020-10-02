package com.example.security.project.securityjwtproject.service;

import com.example.security.project.securityjwtproject.domain.entity.Account;
import com.example.security.project.securityjwtproject.domain.repository.AccountRepository;
import com.example.security.project.securityjwtproject.domain.repository.BoardRepository;
import com.example.security.project.securityjwtproject.exception.CustomException;
import com.example.security.project.securityjwtproject.exception.CustomExceptionErrorList;
import com.example.security.project.securityjwtproject.web.dto.board.PostRegistRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class BoardService {

    private final AccountRepository accountRepository;
    private final BoardRepository boardRepository;

    public Long save(PostRegistRequestDto registRequestDto){
        Account account = accountRepository.findById(registRequestDto.getIdfAccount()).orElseThrow(() -> new CustomException(CustomExceptionErrorList.NOT_EXIST_ACCOUNT));
        return boardRepository.save(registRequestDto.toEntity(account)).getId();
    }

}
