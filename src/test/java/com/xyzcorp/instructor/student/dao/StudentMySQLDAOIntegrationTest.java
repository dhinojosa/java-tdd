package com.xyzcorp.instructor.student.dao;

import com.xyzcorp.instructor.student.domain.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
class StudentMySQLDAOIntegrationTest {
    private static Connection connection;

    @BeforeAll
    static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:tc:mysql:5" +
            ".7.34:///university?user=root&password=&TC_INITSCRIPT" +
            "=init_student_mysql.sql");
    }

    @Test
    @Tag(value = "integration")
    void testPersistStudentFull() throws SQLException, ClassNotFoundException {
        /* Student */
        String firstName = "Cool";
        String lastName = "Moe Dee";
        String studentID = "393912";
        Student student = new Student(firstName, lastName, studentID);

        /* Get connection */
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:tc:mysql:5" +
            ".7.34:///university?user=root&password=&TC_INITSCRIPT" +
            "=init_student_mysql.sql");

        /* Prepare Statement */
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO STUDENT (firstName, lastName, studentId) VALUES (?, " +
                "?, ?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getStudentId());
        preparedStatement.execute();

        /* Generate a copy of object with keys */
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        Optional<Student> result = Optional.empty();
        while (generatedKeys.next()) {
            result = Optional.of(new Student(generatedKeys.getLong(1),
                student.getFirstName(), student.getLastName(),
                student.getStudentId()));
        }

        preparedStatement.close();

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result.get().getId()).isNotEmpty();
        assertThat(result.get().getId().get()).isEqualTo(6L);
        assertThat(result.get().getFirstName()).isEqualTo("Cool");
        assertThat(result.get().getLastName()).isEqualTo("Moe Dee");
    }


    @Test
    void findByStudentID() throws ClassNotFoundException, SQLException {
        /* Prepare Statement */
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE id " +
                "= ?");

        /*set parameters*/
        preparedStatement.setLong(1, 1L);
        preparedStatement.execute();

        /*construct objects*/
        Optional<Student> result = Optional.empty();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String studentId = resultSet.getString(4);
            result = Optional.of(new Student(id, firstName, lastName,
                studentId));
        }

        preparedStatement.close();

        /* Assertions */
        assertThat(result).isNotEmpty();
        assertThat(result.get().getFirstName()).isEqualTo("Rod");
        assertThat(result.get().getLastName()).isEqualTo("Stewart");
        assertThat(result.get().getStudentId()).isEqualTo("001");
    }


    @Test
    void findByLikeFirstNameFull() throws SQLException, ClassNotFoundException {
        /* Prepare Statement */
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE " +
                "firstName like ? ORDER BY firstName");

        preparedStatement.setString(1, "%au%");
        preparedStatement.execute();

        List<Student> result = new ArrayList<>();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String studentId = resultSet.getString(4);
            result.add(new Student(id, firstName, lastName, studentId));
        }

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
    void findByLikeLastName() throws SQLException, ClassNotFoundException {
        /* Prepare Statement */
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE " +
                "lastName like ? ORDER BY lastName");

        preparedStatement.setString(1, "%Car%");
        preparedStatement.execute();

        List<Student> result = new ArrayList<>();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String studentId = resultSet.getString(4);
            result.add(new Student(id, firstName, lastName, studentId));
        }

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

    @AfterAll
    static void tearDown() throws SQLException {
        connection.close();
    }
}

