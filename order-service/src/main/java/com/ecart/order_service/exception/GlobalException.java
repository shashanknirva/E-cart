package com.ecart.order_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<ErrorResponce> runTimeException(RunTimeException runTimeException, HttpServletRequest httpServletRequest){

        ErrorResponce errorResponce = new ErrorResponce();
        errorResponce.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponce.setMessage(runTimeException.getMessage());
        errorResponce.setPath(httpServletRequest.getRequestURI());
        errorResponce.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponce,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
