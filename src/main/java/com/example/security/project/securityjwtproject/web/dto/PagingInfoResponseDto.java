package com.example.security.project.securityjwtproject.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PagingInfoResponseDto {

    private final int totalPages;
    private final long totalElements;

}
