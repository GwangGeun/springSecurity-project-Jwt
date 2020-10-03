package com.example.security.project.securityjwtproject.service;

import com.example.security.project.securityjwtproject.domain.entity.Account;
import com.example.security.project.securityjwtproject.domain.entity.Board;
import com.example.security.project.securityjwtproject.domain.repository.AccountRepository;
import com.example.security.project.securityjwtproject.domain.repository.BoardRepository;
import com.example.security.project.securityjwtproject.exception.CustomException;
import com.example.security.project.securityjwtproject.exception.CustomExceptionErrorList;
import com.example.security.project.securityjwtproject.web.dto.board.BoardListingReponseDto;
import com.example.security.project.securityjwtproject.web.dto.board.BoardListingRequestDto;
import com.example.security.project.securityjwtproject.web.dto.board.BoardRegistRequestDto;
import com.example.security.project.securityjwtproject.web.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class BoardService {

    private final AccountRepository accountRepository;
    private final BoardRepository boardRepository;

    public Long save(BoardRegistRequestDto registRequestDto){
        Account account = accountRepository.findById(registRequestDto.getIdfAccount()).orElseThrow(() -> new CustomException(CustomExceptionErrorList.NOT_EXIST_ACCOUNT));
        return boardRepository.save(registRequestDto.toEntity(account)).getId();
    }

    public Long update(Long id, BoardUpdateRequestDto updateRequestDto){
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(CustomExceptionErrorList.NOT_EXIST_BOARD));
        board.update(updateRequestDto.getTitle(), updateRequestDto.getContent());
        return id;
    }

    public Long delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(CustomExceptionErrorList.NOT_EXIST_BOARD));
        boardRepository.delete(board);
        return id;
    }

    public Page<BoardListingReponseDto> getBoardList(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Board> result = boardRepository.findAll(pageRequest);
        return result.map(entity -> new BoardListingReponseDto(
                entity.getTitle(), entity.getContent(),
                entity.getAccount().getName(),
                entity.getCreatedDate(), entity.getUpdatedDate(),
                entity.getCreatedBy(), entity.getUpdatedBy()));
    }

}
