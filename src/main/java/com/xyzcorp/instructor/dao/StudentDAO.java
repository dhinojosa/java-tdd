package com.xyzcorp.instructor.dao;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    public Optional<Student> persist(Student student) throws StudentDAOException;

    public Optional<Student> findByStudentId(String studentID) throws StudentDAOException;

    public Optional<Student> findById(Long id) throws StudentDAOException;

    public List<Student> findLikeFirstName(String firstName) throws StudentDAOException;

    public List<Student> findLikeLastName(String firstName) throws StudentDAOException;
}
