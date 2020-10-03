package com.example.security.project.securityjwtproject.web.dto.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardListingReponseDto {

    private final String title;
    private final String content;

    private final String username;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;
    private final String createdBy;
    private final String updatedBy;

}
