package com.example.security.project.securityjwtproject.exception;

import lombok.Data;

@Data
public class CustomExceptionResponseDto {
    private int errorCode;
    private String errorMsg;
}
