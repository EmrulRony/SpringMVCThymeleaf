package com.example.springboot.thymeleaf.service;

import java.util.List;

import com.example.springboot.thymeleaf.entity.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public List<Employee> listEmployee();
}
