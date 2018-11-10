package org.employee.dao;

import java.util.List;

import org.employee.dto.Employee;

public interface EmployeeDAO {
	public int saveEmployee(Employee employee);
    //public Employee getEmployeeById(int id);
   //public void updateEmployee(Employee employee);
    //public void deleteEmployee(int id);
    public List<Employee> getAllEmployees();

}
