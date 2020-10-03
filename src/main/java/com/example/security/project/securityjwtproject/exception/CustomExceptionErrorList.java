package com.example.security.project.securityjwtproject.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionErrorList {

    DUPLICATE_ACCOUNT(100, "DUPLICATE_ACCOUNT"),
    NOT_EXIST_ACCOUNT(101, "NOT_EXIST_ACCOUNT"),
    NOT_MATCHED_PASSWORD(102, "NOT_MATCHED_PASSWORD"),
    NOT_EXIST_BOARD(201, "NOT_EXIST_BOARD");

    private final int errorCode;
    private final String errorMsg;
}
