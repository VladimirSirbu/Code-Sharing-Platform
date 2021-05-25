package com.example.CodeSharingPlatform.exception;

public class CodeNotFoundException extends RuntimeException {
    public CodeNotFoundException(String message) {
        super(message);
    }
}
