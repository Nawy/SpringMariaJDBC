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
    	List<Employee> empLondonList = empJdbcTemp.getEmployeeFromCity("London");
    	printEmployeeList(empLondonList);
    	
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
