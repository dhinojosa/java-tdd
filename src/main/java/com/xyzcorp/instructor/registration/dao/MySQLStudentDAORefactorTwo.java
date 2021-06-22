package com.xyzcorp.instructor.registration.dao;

import com.xyzcorp.instructor.registration.domain.StudentDAO;
import com.xyzcorp.instructor.registration.domain.StudentDAOException;
import com.xyzcorp.instructor.registration.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
public class MySQLStudentDAORefactorTwo implements StudentDAO {

    private final String url;

    public MySQLStudentDAORefactorTwo(String url) {
        this.url = url;
    }

    private <A> A withConnection(Function<Connection, A> function) throws StudentDAOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new StudentDAOException(e);
        }
        try (Connection connection = DriverManager.getConnection(url)) {
            return function.apply(connection);
        } catch (SQLException e) {
            throw new StudentDAOException(e);
        }
    }

    private void executeInsert(Student student,
                               PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getStudentId());
        preparedStatement.execute();
    }

    private List<Student> executeFindByName(String name,
                                            PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, "%" + name + "%");
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        return resultSetToListStudents(resultSet);
    }

    private Optional<Student> resultSet2OptionalStudent(ResultSet resultSet) throws SQLException {
        Optional<Student> result = Optional.empty();
        while (resultSet.next()) {
            Long uid = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String studentId = resultSet.getString(4);
            result = Optional.of(new Student(uid, firstName, lastName,
                studentId));
        }
        return result;
    }

    private List<Student> resultSetToListStudents(ResultSet resultSet) throws SQLException {
        List<Student> result = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String studentId = resultSet.getString(4);
            result.add(new Student(id, firstName, lastName, studentId));
        }
        return result;
    }

    @Override
    public Long persist(Student student) throws StudentDAOException {
        return withConnection(connection -> {
            try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                         "INSERT INTO STUDENT (firstName, lastName, " +
                             "studentId) VALUES " +
                             "(?, " +
                             "?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                executeInsert(student, preparedStatement);
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new StudentDAOException("Unable to persist student");
                }
            } catch (SQLException e) {
              e.printStackTrace();
            }
            throw new StudentDAOException("Unable to persist student");
        });
    }

    @Override
    public Optional<Student> findByStudentId(String studentId) throws StudentDAOException {
        return withConnection(connection -> {
            try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                         "SELECT id, firstName, lastName, studentId FROM " +
                             "STUDENT WHERE studentId = ?")) {
                preparedStatement.setString(1, studentId);
                preparedStatement.execute();
                return resultSet2OptionalStudent(preparedStatement.getResultSet());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        });
    }

    @Override
    public Optional<Student> findById(Long id) throws StudentDAOException {
        return withConnection(connection -> {
            try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                         "SELECT id, firstName, lastName, studentId FROM " +
                             "STUDENT " +
                             "WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                preparedStatement.execute();
                return resultSet2OptionalStudent(preparedStatement.getResultSet());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        });
    }

    @Override
    public List<Student> findLikeFirstName(String name) throws StudentDAOException {
        return withConnection(connection -> {
            try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                         "SELECT id, firstName, lastName, studentId FROM " +
                             "STUDENT " +
                             "WHERE" +
                             " firstName like ? ORDER BY firstName")) {
                return executeFindByName(name, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }

    @Override
    public List<Student> findLikeLastName(String name) throws StudentDAOException {
        return withConnection(connection -> {
            try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                         "SELECT id, firstName, lastName, studentId FROM " +
                             "STUDENT " +
                             "WHERE" +
                             " lastName like ? ORDER BY lastName")) {
                return executeFindByName(name, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }
}
