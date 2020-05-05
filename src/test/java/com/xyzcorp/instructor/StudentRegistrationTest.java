package com.xyzcorp.instructor;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentRegistrationTest {
    @Test
    void testRegisterStudent() {
        Student student = new Student("Bob", "Awesome", "202-12-1233");
        Function<Student, Integer> f = (Student s) -> {
            assertThat(s).isEqualTo(student);
            return 30;
        };
        StudentRegistration studentRegistration = new StudentRegistration(f);
        studentRegistration.register(student);
    }

    @Test
    void testRegisterStudentWithARealDAO() {
        StudentDAO realDAO = new StudentDAO() {
            @Override
            public Integer persist(Student student) {
                ///actual call to db
                return 30;
            }
        };
        Student student = new Student("Bob", "Awesome", "202-12-1233");
        Function<Student, Integer> f = realDAO::persist;
        StudentRegistration studentRegistration = new StudentRegistration(f);
        studentRegistration.register(student);
    }
}
