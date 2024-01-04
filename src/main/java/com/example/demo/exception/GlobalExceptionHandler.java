package com.example.demo.exception;

import com.example.demo.dto.ErrorResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseAPI> resourceNotFoundHandling(ResourceNotFoundException exception) {
        ErrorResponseAPI errorDetails = new ErrorResponseAPI(exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ErrorResponse.class)
    public ResponseEntity<ErrorResponseAPI> handlingErrorResponse(ErrorResponse exception) {
        ErrorResponseAPI errorDetails = new ErrorResponseAPI(exception.getErrors());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseAPI> globalExceptionHandling(Exception exception) {
        ErrorResponseAPI errorDetails = new ErrorResponseAPI(exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


