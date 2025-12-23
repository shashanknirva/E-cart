package com.ecart.payment_service.exceptionHandler;

import com.ecart.payment_service.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponce> ErrorHandlor(RuntimeException ex, HttpServletRequest httpServletRequest){

        ErrorResponce errorResponce = new ErrorResponce();
        errorResponce.setPath(httpServletRequest.getRequestURI());
        errorResponce.setMessage(ex.getMessage());
        errorResponce.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorResponce,HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
