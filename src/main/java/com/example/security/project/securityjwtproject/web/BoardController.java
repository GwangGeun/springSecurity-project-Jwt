package com.example.security.project.securityjwtproject.web;

import com.example.security.project.securityjwtproject.service.BoardService;
import com.example.security.project.securityjwtproject.web.dto.PagingInfoResponseDto;
import com.example.security.project.securityjwtproject.web.dto.board.BoardListingReponseDto;
import com.example.security.project.securityjwtproject.web.dto.board.BoardRegistRequestDto;
import com.example.security.project.securityjwtproject.web.dto.board.BoardUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public Long save(@Valid @RequestBody BoardRegistRequestDto registRequestDto){
        return boardService.save(registRequestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @Valid @RequestBody BoardUpdateRequestDto updateRequestDto){
        return boardService.update(id, updateRequestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return boardService.delete(id);
    }

    @GetMapping
    public Result getBoardList(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<BoardListingReponseDto> boardList = boardService.getBoardList(page,size);
        PagingInfoResponseDto pagingInfoDto = new PagingInfoResponseDto(boardList.getTotalPages(), boardList.getTotalElements());
        return new Result(boardList.getContent(),pagingInfoDto);
    }

    @Getter
    @AllArgsConstructor
    static class Result<T1,T2> {
        private T1 data;
        private T2 pagingInfo;
    }
}
