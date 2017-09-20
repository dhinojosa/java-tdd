package com.xyzcorp;

import java.sql.Connection;

public interface EmployeeDAO {
    public int persist(Employee employee);
    public void delete(Employee employee);
}
