package com.xyzcorp.instructor.registration.domain;

import java.util.Objects;
import java.util.Optional;

public class Student {
    private final String studentId;
    private final String firstName;
    private final String lastName;
    private Long id;

    public Student(String firstName, String lastName, String studentId) {
        checkPrerequisites(firstName, lastName, studentId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public Student(Long id, String firstName, String lastName, String studentId) {
        checkPrerequisites(firstName, lastName, studentId);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    private void checkPrerequisites(String firstName, String lastName,
                                    String studentId) {
        Objects.requireNonNull(firstName, "First Name cannot be null");
        Objects.requireNonNull(lastName, "Last Name cannot be null");
        Objects.requireNonNull(studentId, "Student ID cannot be null");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) && firstName.equals(student.firstName) && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName);
    }
}
