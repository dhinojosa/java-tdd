package com.xyzcorp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Test
    public void testServiceForCreatingANewEmployee() {
        //EmployeeDAO, dependency, or collaborator
        EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
        
        //Rehearsal
        when(employeeDAO.persist
                (new Employee("Daniel", "Hinojosa"))).thenReturn(3);
        
        //EmployeeService is my subject under test (SUT)
        EmployeeService employeeService =
                new EmployeeService(employeeDAO);

        int id = employeeService.register
                ("Daniel", "Hinojosa", "Programmer");
        assertEquals(3, id);
    }
}
