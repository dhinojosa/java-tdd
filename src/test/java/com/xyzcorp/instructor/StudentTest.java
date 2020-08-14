package com.xyzcorp.instructor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    @Test
    public void testConstruction() {
        Long studentID = 100L;
        String firstName = "Ann";
        String lastName = "Lopez";
        Student student = new Student(studentID, firstName, lastName);
        assertThat(student.getFirstName()).isEqualTo(firstName);
        assertThat(student.getLastName()).isEqualTo(lastName);
        assertThat(student.getStudentID()).isEqualTo(studentID);
    }
}
