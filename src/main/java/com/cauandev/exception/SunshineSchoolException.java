package com.cauandev.exception;

public abstract class SunshineSchoolException extends RuntimeException {
    public SunshineSchoolException(String message) {
        super(message);
    }
    public SunshineSchoolException(String message, Throwable cause) { super(message, cause); }
}
