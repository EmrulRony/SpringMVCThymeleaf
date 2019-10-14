package com.example.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.example.springboot.thymeleaf.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
}
