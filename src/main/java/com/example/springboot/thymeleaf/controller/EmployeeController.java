package com.example.springboot.thymeleaf.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		System.out.println(employee);
		service.addEmployee(employee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		model.addAttribute("employee", employee);
		return "employee/save-employee.html";
	}
	
	@GetMapping("/findById")
	public String findEmpById(@RequestParam("empId") String id, Model model) {
		int empId=Integer.parseInt(id);
		Employee emp = service.findEmployee(empId);
		model.addAttribute("employee_list", emp);
		return "employee/list-employees.html";
	}
	
	@GetMapping("/delete")
	public String delById(@RequestParam ("id") int id) {
		service.deleteEmployee(id);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("id") int id, Model model) {
		Employee emp = service.findEmployee(id);
		System.out.println("#####"+emp);
		model.addAttribute(emp);
		return "employee/save-employee";
	}
}
