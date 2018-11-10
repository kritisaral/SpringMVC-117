package org.employee.controller;

import java.util.List;

import org.employee.dao.EmployeeDAO;
import org.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDAO employeedao;

	@RequestMapping("/EmployeeForm")
	public ModelAndView showform() {
		return new ModelAndView("EmployeeForm", "command", new Employee());
	}

	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeedao.saveEmployee(employee);
		return new ModelAndView("redirect:/ViewEmployee");
	}

	@RequestMapping(value="/ViewEmployee", method = RequestMethod.GET)
	public ModelAndView viewemp() {
		List<Employee> list = employeedao.getAllEmployees();
		System.out.println(list);
		System.out.println(list.size());

		return new ModelAndView("ViewEmployee", "list", list);
	}

}
