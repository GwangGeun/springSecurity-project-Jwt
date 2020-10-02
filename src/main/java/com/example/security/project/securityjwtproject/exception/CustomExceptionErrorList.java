package com.example.security.project.securityjwtproject.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionErrorList {

    NOT_EXIST_ACCOUNT(101, "NOT_EXIST_ACCOUNT");

    private final int errorCode;
    private final String errorMsg;
}
