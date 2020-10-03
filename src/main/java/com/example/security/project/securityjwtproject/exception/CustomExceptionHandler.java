package com.example.security.project.securityjwtproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    // BusinessLogic error 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponseDto> customException(CustomException customException){
        CustomExceptionResponseDto customExceptionResponseDto = new CustomExceptionResponseDto();
        customExceptionResponseDto.setErrorCode(customException.getErrorList().getErrorCode());
        customExceptionResponseDto.setErrorMsg(customException.getErrorList().getErrorMsg());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customExceptionResponseDto);
    }

    // @Valid annotation error 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionResponseDto> customException(MethodArgumentNotValidException methodArgumentNotValidException){
        CustomExceptionResponseDto customExceptionResponseDto = new CustomExceptionResponseDto();
        customExceptionResponseDto.setErrorCode(700);
        customExceptionResponseDto.setErrorMsg(methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customExceptionResponseDto);
    }


}
