package com.ermolaev.springorm;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeJDBCTemplate implements EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	public void create(String firstName, String lastName, Integer age,
			String city, Float salary) {
		String SQL = "insert into employees " +
					 	"(firstName, lastName, age, city, salary)" +
					 	" values (?, ?, ?, ?, ?)";
		
		jdbcTemplateObject.update(SQL, firstName, lastName, age, city, salary);
	}
	
	public void delete(Integer index)
	{
		String SQL ="delete from employees where id = ?";
		jdbcTemplateObject.update(SQL, index);
	}
	
	public void deleteByFirstName(String name)
	{
		String SQL ="delete from employees where firstName = ?";
		jdbcTemplateObject.update(SQL, name);		
	}

	public Employee getEmployee(Integer index) {
		String SQL = "select * from employees where id= ?";
		Employee emp = jdbcTemplateObject
				.queryForObject(SQL, new Object[]{index}, new EmployeeMapper());
		return emp;
	}
	
	public List<Employee> getEmployeeOrderByAge() {
		String SQL = "select * from employees order by age";
		List<Employee> empList = jdbcTemplateObject.query(SQL, new EmployeeMapper());
		return empList;
	}

	public List<Employee> getEmployeeList() {
		String SQL = "select * from employees";
		List<Employee> empList = jdbcTemplateObject.query(SQL, new EmployeeMapper());
		
		return empList;
	}

	public List<Employee> getEmployeeFromCity(String city) {
		String SQL = "select * from employees where city = ?";
		List<Employee> empList = 
				jdbcTemplateObject.query(SQL, new Object[]{city}, new EmployeeMapper());
		return empList;
	}

}
