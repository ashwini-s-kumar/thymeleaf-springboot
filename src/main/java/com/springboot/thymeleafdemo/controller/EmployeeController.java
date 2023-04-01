package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", employeeService.findAll() );
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	private String showFormAdd(Model theModel){
		Employee emp = new Employee();
		theModel.addAttribute("employee",emp);
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	private String showFormUpdate(@RequestParam("employeeId")int id,  Model theModel){
		Employee emp = employeeService.findById(id);
		theModel.addAttribute("employee",emp);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	private String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	private String deleteEmployee(@RequestParam("employeeId")int id){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}









