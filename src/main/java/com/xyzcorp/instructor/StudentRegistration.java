package com.xyzcorp.instructor;

import java.util.function.Function;

public class StudentRegistration {
    private Function<Student, Integer> studentDAO;

    public StudentRegistration(Function<Student, Integer> studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void register(Student student) {
          studentDAO.apply(student);
    }
}
