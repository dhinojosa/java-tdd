package com.xyzcorp.instructor.student.dao;

import com.xyzcorp.instructor.student.dao.domain.StudentDAOException;
import com.xyzcorp.instructor.student.domain.Student;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
class StudentMySQLDAORefactorOneIntegrationTest {

    @Test
    @Tag(value = "integration")
    void testPersistStudent() throws StudentDAOException {
        /* Student */
        String firstName = "Cool";
        String lastName = "Moe Dee";
        String studentID = "393912";
        Student student = new Student(firstName, lastName, studentID);

        MySQLStudentDAORefactorOne mySQLStudentDAORefactorOne =
            new MySQLStudentDAORefactorOne("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        Optional<Student> result =
            mySQLStudentDAORefactorOne.persist(student);

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result.get().getId()).isNotEmpty();
        assertThat(result.get().getId().get()).isEqualTo(6L);
        assertThat(result.get().getFirstName()).isEqualTo("Cool");
    }


    @Test
    @Tag(value = "integration")
    void testFindById() throws StudentDAOException {
        MySQLStudentDAORefactorOne mySQLStudentDAORefactorOne =
            new MySQLStudentDAORefactorOne("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        Optional<Student> result =
            mySQLStudentDAORefactorOne.findById(1L);

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result.get().getFirstName()).isEqualTo("Rod");
        assertThat(result.get().getLastName()).isEqualTo("Stewart");
        assertThat(result.get().getStudentId()).isEqualTo("001");
    }

    @Test
    @Tag(value = "integration")
    void findByLikeFirstName() throws StudentDAOException {
        MySQLStudentDAORefactorOne mySQLStudentDAORefactorOne =
            new MySQLStudentDAORefactorOne("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        List<Student> result =
            mySQLStudentDAORefactorOne.findLikeFirstName("au");

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
        MySQLStudentDAORefactorOne mySQLStudentDAORefactorOne =
            new MySQLStudentDAORefactorOne("jdbc:tc:mysql:5" +
                ".7.34:///university?user=root&password=&xTC_INITSCRIPT" +
                "=init_student_mysql.sql");

        List<Student> result =
            mySQLStudentDAORefactorOne.findLikeLastName("Car");

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
