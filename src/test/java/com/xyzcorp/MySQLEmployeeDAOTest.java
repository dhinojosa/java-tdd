package com.xyzcorp;

import static org.mockito.Mockito.mock;

import java.sql.Connection;

public class MySQLEmployeeDAOTest {

	public void testConnection() {
		Connection connection = mock(Connection.class);

		// Subject Under Test
		MySQLEmployeeDAO msed = new MySQLEmployeeDAO(() -> connection);
		
		msed.persist(null);

	}

}
