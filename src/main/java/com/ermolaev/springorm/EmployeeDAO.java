package com.ermolaev.springorm;

import java.util.List;

import javax.sql.DataSource;

public interface EmployeeDAO {
	
	public void setDataSource(DataSource ds);
	
	public void create(String firstName, String lastName, Integer age, String city, Float salary);
	
	public void delete(Integer index);
	
	public void deleteByFirstName(String name);
	
	public Employee getEmployee(Integer index);
	
	public List<Employee> getEmployeeList();
	
	public List<Employee> getEmployeeFromCity(String city);
}
