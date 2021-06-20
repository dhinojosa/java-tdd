package com.xyzcorp.instructor.student.domain;

import java.util.Optional;

public class Student {
    private final String studentId;
    private String firstName;
    private String lastName;
    private Long id;

    public Student(String firstName, String lastName, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public Student(Long id, String firstName, String lastName, String studentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }
}
