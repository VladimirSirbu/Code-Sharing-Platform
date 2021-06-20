package com.example.CodeSharingPlatform.exception;

import java.util.function.Supplier;

public class CodeNotFoundException extends RuntimeException {

    public CodeNotFoundException() {
        super();
    }

    public CodeNotFoundException(String message) {
        super(message);
    }
}
