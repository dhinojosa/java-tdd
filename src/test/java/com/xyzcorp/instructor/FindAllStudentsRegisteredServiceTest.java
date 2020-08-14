package com.xyzcorp.instructor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.mock;

public class FindAllStudentsRegisteredServiceTest {

    @Test
    public void testSomething() {
        FindAllStudentsRegisteredService findAllStudentsRegisteredService =
            new FindAllStudentsRegisteredStandardService((String n) ->
                Arrays.asList(new Student(3023L, "Nancy", "Rogers")));
        Map<Character, List<Student>> result =
            findAllStudentsRegisteredService.groupByFirstLetterOfLastName();
    }

    @Test
    public void testSomethingIntegration() {
        StudentDAO studentDAO = new StudentDAO() {
            @Override
            public Long persist(Student student) {
                return null;
            }

            @Override
            public Optional<Student> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public List<Student> findByLastName(String lastName) {
                return null;
            }
        };


        FindAllStudentsRegisteredService findAllStudentsRegisteredService =
            new FindAllStudentsRegisteredStandardService(studentDAO::findByLastName);
        Map<Character, List<Student>> result =
            findAllStudentsRegisteredService.groupByFirstLetterOfLastName();
    }
}
