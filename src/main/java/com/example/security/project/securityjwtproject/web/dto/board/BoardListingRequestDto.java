package com.example.security.project.securityjwtproject.web.dto.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BoardListingRequestDto {

    private final int page;
    private final int size;
}
