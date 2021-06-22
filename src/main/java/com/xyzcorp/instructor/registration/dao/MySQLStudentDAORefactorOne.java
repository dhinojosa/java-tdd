package com.xyzcorp.instructor.registration.dao;

import com.xyzcorp.instructor.registration.domain.Student;
import com.xyzcorp.instructor.registration.domain.StudentDAO;
import com.xyzcorp.instructor.registration.domain.StudentDAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
public class MySQLStudentDAORefactorOne implements StudentDAO {
    private final String url;

    public MySQLStudentDAORefactorOne(String url) {
        this.url = url;
    }

    @Override
    public Long persist(Student student) throws StudentDAOException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement =
                prepareInsertStudentStatement(student, connection);
            preparedStatement.execute();
            /* Generate a copy of object with keys */
            return getPrimaryKey(preparedStatement);
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
    }

    private long getPrimaryKey(PreparedStatement preparedStatement) throws SQLException {
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        } else {
            throw new StudentDAOException("Unable to persist student");
        }
    }

    private Connection getConnection() throws ClassNotFoundException,
        SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url);
    }

    private PreparedStatement prepareInsertStudentStatement(Student student,
                                                            Connection connection) throws SQLException {
        /* Prepare Statement */
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO STUDENT (firstName, lastName, studentId) VALUES (?, " +
                "?, ?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getStudentId());

        return preparedStatement;
    }

    @Override
    public Optional<Student> findByStudentId(String studentID) throws StudentDAOException {
        try {
            /* Prepare Statement */
            PreparedStatement preparedStatement =
                getConnection().prepareStatement(
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
            /* Prepare Statement */
            PreparedStatement preparedStatement =
                getConnection().prepareStatement(
                "SELECT id, firstName, lastName, studentId FROM STUDENT WHERE" +
                    " id = ?");

            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            Optional<Student> result = Optional.empty();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
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
    public List<Student> findLikeFirstName(String name) throws StudentDAOException {
        List<Student> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                getConnection().prepareStatement(
                    "SELECT id, firstName, lastName, studentId FROM STUDENT " +
                        "WHERE" +
                        " firstName like ? ORDER BY firstName");

            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String studentId = resultSet.getString(4);
                result.add(new Student(id, firstName, lastName, studentId));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
        return result;
    }

    @Override
    public List<Student> findLikeLastName(String name) throws StudentDAOException {
        List<Student> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                getConnection().prepareStatement(
                    "SELECT id, firstName, lastName, studentId FROM STUDENT " +
                        "WHERE" +
                        " lastName like ? ORDER BY lastName");

            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String studentId = resultSet.getString(4);
                result.add(new Student(id, firstName, lastName, studentId));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
        return result;
    }
}
