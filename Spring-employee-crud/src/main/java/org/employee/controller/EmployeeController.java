package org.employee.controller;

import java.util.List;

import org.employee.dao.EmployeeDAO;
import org.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
@Autowired
EmployeeDAO employeedao;
@RequestMapping("/saveEmp,RequestMethod.post")
public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee)
{
	employeedao.saveEmployee(employee);
	return new ModelAndView("redirect:/ViewEmployee");
}

@RequestMapping("/ViewEmployee")  
public ModelAndView viewemp(){  
    List<Employee> list=employeedao.getAllEmployees();  
    return new ModelAndView("ViewEmployee","list",list);  
}  

}
