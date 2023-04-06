package com.vinothit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import com.vinothit.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import com.vinothit.repo.EmployeeRepository;

//org.springframework.data.domain.Sort

@SpringBootApplication
public class Application_Sorting {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application_Sorting.class, args);
		
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		
		//System.out.println(repository.getClass().getName());
		
		// 1. Insert Data into Employee Table through SaveAll method through Repo.
		/*Employee e1=new Employee(2, "Orlen", 5000.00, "Male", "Sales");
		Employee e2=new Employee(3, "Charles", 15000.00, "Male", "Admin");
		Employee e3=new Employee(4, "Smith", 25000.00, "Male", "Marketing");
		Employee e4=new Employee(5, "Cathy", 35000.00, "Fe-Male", "Account");
		Employee e5=new Employee(6, "Robert", 45000.00, "Male", "HR");
		Employee e6=new Employee(7, "David", 55000.00, "Male", "Manager");
		
		
		repository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		
		System.out.println("Employee entity is stored successfully in MySQL DB....  :: ");*/
		
		
		//Requirement 1 : Need to retrieve the records based on Employee Name in ascending order
	    Sort sort1 = Sort.by("empName").ascending();
		
	    System.out.println("To retrieve the records based on Employee Name in ascending order");
	    
		List<Employee> emps_ascending = repository.findAll(sort1);
		
		emps_ascending.forEach(System.out:: println); // Introduced Java1.8 Version - To Display all records through Method Reference.
		
		//Requirement 2 : Need to retrieve the records based on Employee Name in descending order
	    Sort sort2 = Sort.by("empName").descending();
	    
	    System.out.println("To retrieve the records based on Employee Name in descending order");
		
		List<Employee> emps_descending = repository.findAll(sort2);
		
		emps_descending.forEach(System.out:: println); // Introduced Java1.8 Version - To Display all records through Method Reference.
		
		//Requirement 3 : Need to retrieve the records based on Employee Salary in descending order
	    Sort sort3 = Sort.by("empSalary").descending();
	    
	    System.out.println("To retrieve the records based on Employee Salary in descending order");
		
		List<Employee> sal_descending = repository.findAll(sort3);
		
		sal_descending.forEach(System.out:: println); // Introduced Java1.8 Version - To Display all records through Method Reference.
		
		//Requirement 4 : Need to retrieve the records based on Multiple both Employee Name & Salary in descending order
	    Sort sort4 = Sort.by("empName","empSalary").descending();
	    
	    System.out.println("To retrieve the records based on Multiple both Employee Name & Salary in descending order");
		
		List<Employee> both_descending = repository.findAll(sort4);
		
		both_descending.forEach(System.out:: println); // Introduced Java1.8 Version - To Display all records through Method Reference.
		
		
		
		
		
	}

}
