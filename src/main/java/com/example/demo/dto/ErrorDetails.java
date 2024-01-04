package com.example.demo.dto;

public class ErrorDetails {
    private String message;
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    public ErrorDetails(String field, String message) {
        this.field = field;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
