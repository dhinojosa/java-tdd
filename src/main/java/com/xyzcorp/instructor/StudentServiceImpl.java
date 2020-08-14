package com.xyzcorp.instructor;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public boolean registerStudent(Student student) {
        Optional<Student> byId =
            studentDAO.findById(student.getStudentID());
        if (!byId.isPresent()) {
            studentDAO.persist(student);
            return true;
        }
        return false;
    }
}
