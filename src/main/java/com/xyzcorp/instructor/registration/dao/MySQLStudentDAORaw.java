package com.xyzcorp.instructor.registration.dao;

import com.xyzcorp.instructor.registration.domain.Student;
import com.xyzcorp.instructor.registration.domain.StudentDAO;
import com.xyzcorp.instructor.registration.domain.StudentDAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
public class MySQLStudentDAORaw implements StudentDAO {

    @Override
    public Long persist(Student student) throws StudentDAOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:tc" +
                ":mysql:5.7.34:///university?user=root&password" +
                "=&xTC_INITSCRIPT=init_student_mysql.sql");

            /* Prepare Statement */
            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO STUDENT (firstName, lastName, studentId) VALUES " +
                    "(?, " +
                    "?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getStudentId());
            preparedStatement.execute();
            /* Generate a copy of object with keys */
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
            throw new StudentDAOException("Unable to persist");
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
    }

    @Override
    public Optional<Student> findByStudentId(String studentID) throws StudentDAOException {
        try {
            /* Get connection */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:tc" +
                ":mysql:5" +
                ".7.34:///university?user=root&password=&TC_INITSCRIPT" +
                "=init_student_mysql.sql");

            /* Prepare Statement */
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE" +
                    " id " +
                    "= ?");

            preparedStatement.setLong(1, 1L);
            preparedStatement.execute();

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
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
    }

    @Override
    public Optional<Student> findById(Long id) throws StudentDAOException {
        try {
            /* Get connection */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:tc" +
                ":mysql:5" +
                ".7.34:///university?user=root&password=&TC_INITSCRIPT" +
                "=init_student_mysql.sql");

            /* Prepare Statement */
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE" +
                    " id " +
                    "= ?");

            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            Optional<Student> result = Optional.empty();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Long key = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String studentId = resultSet.getString(4);
                result = Optional.of(new Student(key, firstName, lastName,
                    studentId));
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
    }

    @Override
    public List<Student> findLikeFirstName(String name) throws StudentDAOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:tc" +
                ":mysql:5" +
                ".7.34:///university?user=root&password=&TC_INITSCRIPT" +
                "=init_student_mysql.sql");

            /* Prepare Statement */
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE" +
                    " " +
                    "firstName like ? ORDER BY firstName");

            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            List<Student> result = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String studentId = resultSet.getString(4);
                result.add(new Student(id, firstName, lastName, studentId));
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
    }

    @Override
    public List<Student> findLikeLastName(String name) throws StudentDAOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:tc" +
                ":mysql:5" +
                ".7.34:///university?user=root&password=&TC_INITSCRIPT" +
                "=init_student_mysql.sql");

            /* Prepare Statement */
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE" +
                    " lastName like ? ORDER BY lastName");

            preparedStatement.setString(1, "%" + name + "%");
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
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
    }
}
