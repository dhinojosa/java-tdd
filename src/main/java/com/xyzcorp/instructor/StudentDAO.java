package com.xyzcorp.instructor;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    Long persist(Student student);
    Optional<Student> findById(Long id);
    List<Student> findByLastName(String lastName);
}
