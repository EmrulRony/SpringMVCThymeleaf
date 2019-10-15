package com.example.springboot.thymeleaf.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.thymeleaf.entity.Employee;
import com.example.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	Employee employee;
	
	@GetMapping("/test")
	public String testMet(Model model) {
		model.addAttribute("test", new Date());
		return "test";
	}
	
	@GetMapping("/list")
	public String listAllEmployees(Model model) {
		model.addAttribute("employee_list", service.listEmployees());
		return "employee/list-employees.html";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.addEmployee(employee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		model.addAttribute("employee", employee);
		return "employee/save-employee.html";
	}
	
}
