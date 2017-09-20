package com.xyzcorp;

import java.sql.Connection;
import java.util.function.Supplier;

public class MySQLEmployeeDAO implements EmployeeDAO {

	private Supplier<Connection> supplier;
	
	public MySQLEmployeeDAO(Supplier<Connection> supplier) {
		this.supplier = supplier;
	}
	
	@Override
	public int persist(Employee employee) {
		Connection connection = supplier.get();
		return 0;
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
