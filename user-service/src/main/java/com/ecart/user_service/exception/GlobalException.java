package com.ecart.user_service.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponce> userNotFoundException(UserNotFoundException ex, HttpServletRequest request){
        ErrorResponce errorResponce = new ErrorResponce();

        errorResponce.setMessage(ex.getMessage());
        errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponce.setError("Resource Not Found");
        errorResponce.setPath(request.getRequestURI());
        errorResponce.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(errorResponce,HttpStatus.NOT_FOUND);


    }



}
