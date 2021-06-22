package com.xyzcorp.instructor.registration.domain;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    Long persist(Student student) throws StudentDAOException;

    Optional<Student> findByStudentId(String studentID) throws StudentDAOException;

    Optional<Student> findById(Long id) throws StudentDAOException;

    List<Student> findLikeFirstName(String firstName) throws StudentDAOException;

    List<Student> findLikeLastName(String firstName) throws StudentDAOException;
}
