package com.example.security.project.securityjwtproject.web.dto.board;

import com.example.security.project.securityjwtproject.domain.entity.Account;
import com.example.security.project.securityjwtproject.domain.entity.Board;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostRegistRequestDto {

    @NotNull(message = "idfAccount 가 없습니다.")
    private Long idfAccount;
    @NotBlank(message = "title 이 없습니다.")
    private String title;
    @NotBlank(message = "cotent 가 없습니다.")
    private String content;

    @Builder
    public PostRegistRequestDto(Long idfAccount, String title, String content){
        this.idfAccount = idfAccount;
        this.title = title;
        this.content = content;
    }

    public Board toEntity(Account account){
        return Board.builder().account(account).title(title).content(content).build();
    }
}
