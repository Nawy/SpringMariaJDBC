package com.ermolaev.springorm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setFirstName(rs.getString("firstName"));
		emp.setLastName(rs.getString("lastName"));
		emp.setAge(rs.getInt("age"));
		emp.setCity(rs.getString("city"));
		emp.setSalary(rs.getFloat("salary"));
		return emp;
	}
}
