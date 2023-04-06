package com.vinothit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import com.vinothit.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.vinothit.repo.EmployeeRepository;

//org.springframework.data.domain.Sort

@SpringBootApplication
public class Application_QueryByExampleExecutor {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application_QueryByExampleExecutor.class, args);
		
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
		
		//Requirement 0 : Need to retrieve the records based on Gender and Department through QueryByExampleExecutor concept.....
		System.out.println("To retrieve the records based on Gender and Department through QueryByExampleExecutor concept.....");
		
		Employee emp=new Employee();
		emp.setEmpGender("Male");
		emp.setDept("IT");
		
		Example<Employee> example = Example.of(emp);
		List<Employee> emps = repository.findAll(example);
		
		emps.forEach(System.out::println);
		
		//Requirement 2 : Need to retrieve the records based on Native Query concept in JPARepository interface as well...
		System.out.println("To retrieve the records based on Native Query concept in JPARepository interface as well....");
		List<Employee> emps2 = repository.getEmps();
		emps2.forEach(System.out::println);

		
	}

}
