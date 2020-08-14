package com.xyzcorp.instructor;

public class Student {
    private Long studentID;
    private String firstName;
    private String lastName;

    public Student(Long studentID, String firstName, String lastName) {

        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getStudentID() {
        return studentID;
    }
}
