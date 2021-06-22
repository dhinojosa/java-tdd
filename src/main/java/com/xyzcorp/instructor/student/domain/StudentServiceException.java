package com.xyzcorp.instructor.student.domain;

public class StudentServiceException extends Exception{
    public StudentServiceException() {
    }

    public StudentServiceException(String message) {
        super(message);
    }

    public StudentServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentServiceException(Throwable cause) {
        super(cause);
    }

    public StudentServiceException(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
