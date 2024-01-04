package com.example.demo.dto;

import java.util.List;

public class ErrorResponseAPI {
    private String errorMessage;
    private List<ErrorDetails> errorDetailsList;

    public ErrorResponseAPI(List<ErrorDetails> errors) {
        this.errorDetailsList= errors;
    }

    public ErrorResponseAPI(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<ErrorDetails> getErrorDetailsList() {
        return errorDetailsList;
    }

    public void setErrorDetailsList(List<ErrorDetails> errorDetailsList) {
        this.errorDetailsList = errorDetailsList;
    }
}

