package com.ermolaev.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("/**/Beans.xml");
    	
    	EmployeeJDBCTemplate empJdbcTemp = 
    			(EmployeeJDBCTemplate)ctx.getBean("employeeJDBCTemplate");
    	
    	
    	System.out.println("----------- All Employees --------------");
    	List<Employee> empList = empJdbcTemp.getEmployeeList();
    	printEmployeeList(empList);
    	
    	System.out.println("\n----------- From London --------------");
    	empList = empJdbcTemp.getEmployeeFromCity("London");
    	printEmployeeList(empList);
    	
    	System.out.println("\n----------- Add New Employee --------------");
    	empJdbcTemp.create("Demi", "Moore", 32, "New Jersey", 22000F);
    	empList = empJdbcTemp.getEmployeeList();
    	printEmployeeList(empList);
    	
    	System.out.println("\n----------- Remove Employee --------------");
    	empJdbcTemp.deleteByFirstName("Demi");
    	empList = empJdbcTemp.getEmployeeOrderByAge();
    	printEmployeeList(empList);
    }
    
    private static void printEmployeeList(List<Employee> empList)
    {
    	for(Employee emp : empList)
    	{
    		System.out.println(
    				String.format("%d %s %s %d %s %.2f",
    						emp.getId(),
    						emp.getFirstName(),
    						emp.getLastName(),
    						emp.getAge(),
    						emp.getCity(),
    						emp.getSalary()
    				)
    		);
    	}      	
    }
}
