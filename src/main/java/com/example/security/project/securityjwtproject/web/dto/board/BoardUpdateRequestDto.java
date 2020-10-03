package com.example.security.project.securityjwtproject.web.dto.board;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

//@Data
@Getter
public class BoardUpdateRequestDto {

    @NotBlank(message = "title 이 없습니다.")
    private String title;
    @NotBlank(message = "cotent 가 없습니다.")
    private String content;

    @Builder
    public BoardUpdateRequestDto(Long idfBoard, String title, String content){
        this.title = title;
        this.content = content;
    }
}
