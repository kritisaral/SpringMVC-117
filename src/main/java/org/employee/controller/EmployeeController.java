package org.employee.controller;

import java.util.List;

import org.employee.dao.EmployeeDAO;
import org.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		

		return new ModelAndView("ViewEmployee", "list", list);
	}
	
	   @RequestMapping(value="/editemployee/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        Employee employee=employeedao.getEmployeeById(id);  
	        return new ModelAndView("editemployee","command",employee);  
	    }  
	   
	   @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("employee") Employee employee){  
		   employeedao.updateEmployee(employee);  
	        return new ModelAndView("redirect:/ViewEmployee");  
	    }  
	   
	    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	    	employeedao.deleteEmployee(id);  
	        return new ModelAndView("redirect:/ViewEmployee");  
	    }  


}
