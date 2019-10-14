package com.example.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.thymeleaf.dao.EmployeeDao;
import com.example.springboot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao dao;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee emp=dao.getOne(id);
		dao.delete(emp);
		return emp;
	}

	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
