package com.example.security.project.securityjwtproject.web;

import com.example.security.project.securityjwtproject.service.BoardService;
import com.example.security.project.securityjwtproject.web.dto.board.PostRegistRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/regist")
    public Long save(@Valid @RequestBody PostRegistRequestDto registRequestDto){
        return boardService.save(registRequestDto);
    }
}
