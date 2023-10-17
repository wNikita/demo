package com.example.demo.exception;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException() {
        super("Name already exists.");
    }

    public DuplicateNameException(String message) {
        super(message);
    }
}
