package com.example.security.project.securityjwtproject.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    CustomExceptionErrorList errorList;

    public CustomException(CustomExceptionErrorList errorList){
        this.errorList = errorList;
    }

}
