package com.example.demo.exception;


import com.example.demo.dto.ErrorDetails;

import java.util.List;


public class ErrorResponse extends RuntimeException {
    private List<ErrorDetails> errors;


    public ErrorResponse(List<ErrorDetails> errors) {
        super("Errors occurred");
        this.errors = errors;
    }

    public List<ErrorDetails> getErrors() {
        return errors;
    }
}
