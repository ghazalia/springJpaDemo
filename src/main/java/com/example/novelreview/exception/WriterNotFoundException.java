package com.example.novelreview.exception;

public class WriterNotFoundException extends RuntimeException {
    public WriterNotFoundException() {
        super();
    }

    public WriterNotFoundException(String message) {
        super(message);
    }
}
