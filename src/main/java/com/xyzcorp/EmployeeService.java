package com.xyzcorp;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public int register(String firstName,
                        String lastName,
                        String title) {
        return employeeDAO.persist(
                new Employee(firstName, lastName));
    }
}
