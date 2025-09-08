package com.example.SpringBoot_jpa_methord;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	

		
	    List<Employee> findByName(String name);
	    List<Employee> findByCity(String city);
	    List<Employee> findByNameOrCity(String name, String city);
	    List<Employee> findByAgeIn(List<Integer> age);
	    
	  
	    
	}


