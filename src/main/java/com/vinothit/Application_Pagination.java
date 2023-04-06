package com.vinothit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import com.vinothit.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.vinothit.repo.EmployeeRepository;

//org.springframework.data.domain.Sort

@SpringBootApplication
public class Application_Pagination {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application_Pagination.class, args);
		
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
		
		//Requirement 0 : Need to retrieve the records based on Multiple both Employee Name & Salary in descending order
		System.out.println("To retrieve the records based on Multiple both Employee Name & Salary in descending order");
		Sort sort = Sort.by("empName","empSalary").descending();
		List<Employee> emps0 = repository.findAll(sort);
		emps0.forEach(System.out::println);
		
		
		//Requirement 1 : Need to retrieve the records based on PAGINATION concept with Page Number and Size.....	
		System.out.println("To retrieve the records based on PAGINATION concept with Page Number and Size.....");
		int pageNo=1;
		
		PageRequest page = PageRequest.of(pageNo-1, 3);
		
		Page<Employee> findAll = repository.findAll(page);
		List<Employee> emps = findAll.getContent();
		
		emps.forEach(System.out::println);
		
		

		
	}

}
