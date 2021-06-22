package com.xyzcorp.instructor.registration.domain;

import java.util.Optional;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student registerStudent(String firstName, String lastName,
                                   String studentID) throws StudentServiceException {
        try {
            Optional<Student> option = studentDAO.findByStudentId(studentID);
            if (option.isEmpty()) {
                Long id = studentDAO.persist(new Student(firstName, lastName,
                    studentID));
                return new Student(id, firstName, lastName, studentID);
            } else throw new StudentServiceException(String.format("%s %s is " +
                "already registered", firstName, lastName));
        } catch (StudentDAOException e) {
            throw new StudentServiceException(e);
        }
    }
}
