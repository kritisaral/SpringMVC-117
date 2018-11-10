package org.employee.dao;

import java.util.List;

import org.employee.dto.Employee;

public interface EmployeeDAO {
	public int saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
   public int updateEmployee(Employee employee);
    public int deleteEmployee(int id);
    public List<Employee> getAllEmployees();

}
