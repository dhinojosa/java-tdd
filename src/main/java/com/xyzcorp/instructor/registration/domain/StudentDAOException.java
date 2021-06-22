package com.xyzcorp.instructor.registration.domain;

public class StudentDAOException extends RuntimeException{
    public StudentDAOException() {
        super();
    }

    public StudentDAOException(String message) {
        super(message);
    }

    public StudentDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentDAOException(Throwable cause) {
        super(cause);
    }

    protected StudentDAOException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
