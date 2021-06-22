package com.xyzcorp.instructor.registration.dao;

import com.xyzcorp.instructor.registration.domain.Student;
import com.xyzcorp.instructor.registration.domain.StudentDAO;
import com.xyzcorp.instructor.registration.domain.StudentDAOException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
@Tag(value = "integration")
class StudentMySQLDAORefactorTwoIntegrationTest {

    @Test
    void testPersistStudent() throws StudentDAOException {
        /* Student */
        String firstName = "Cool";
        String lastName = "Moe Dee";
        String studentID = "393912";
        Student student = new Student(firstName, lastName, studentID);

        StudentDAO studentDAO =
            new MySQLStudentDAORefactorTwo("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        Long result =
            studentDAO.persist(student);

        /* Assertions */
        assertThat(result).isGreaterThan(0L);
    }


    @Test
    void testFindById() throws StudentDAOException {
        StudentDAO studentDAO =
            new MySQLStudentDAORefactorTwo("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        Optional<Student> result =
            studentDAO.findById(1L);

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result.get().getFirstName()).isEqualTo("Rod");
        assertThat(result.get().getLastName()).isEqualTo("Stewart");
        assertThat(result.get().getStudentId()).isEqualTo("001");
    }

    @Test
    @Tag(value = "integration")
    void findByLikeFirstName() throws StudentDAOException {
        StudentDAO studentDAO =
            new MySQLStudentDAORefactorTwo("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        List<Student> result =
            studentDAO.findLikeFirstName("au");

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getFirstName()).isEqualTo("Paul");
        assertThat(result.get(0).getLastName()).isEqualTo("McCartney");
        assertThat(result.get(0).getStudentId()).isEqualTo("002");
        assertThat(result.get(1).getFirstName()).isEqualTo("Paula");
        assertThat(result.get(1).getLastName()).isEqualTo("Abdul");
        assertThat(result.get(1).getStudentId()).isEqualTo("004");
    }

    @Test
    @Tag(value = "integration")
    void findByLikeLastName() throws StudentDAOException {
        StudentDAO studentDAO =
            new MySQLStudentDAORefactorTwo("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        List<Student> result =
            studentDAO.findLikeLastName("Car");

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getFirstName()).isEqualTo("Karen");
        assertThat(result.get(0).getLastName()).isEqualTo("Carpenter");
        assertThat(result.get(0).getStudentId()).isEqualTo("005");
        assertThat(result.get(1).getFirstName()).isEqualTo("Paul");
        assertThat(result.get(1).getLastName()).isEqualTo("McCartney");
        assertThat(result.get(1).getStudentId()).isEqualTo("002");
    }
}

