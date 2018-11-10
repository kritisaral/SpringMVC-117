package org.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.employee.dto.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int saveEmployee(Employee employee){
		 
		    String sql="insert into EMPLOYEE(id,name,department,age) values('"+employee.getId()+"',"+employee.getName()+",'"+employee.getDept()+"',"+employee.getAge()+")";  
		    return template.update(sql);  
		
		
	}
    public List<Employee> getAllEmployees()
    {
    	return template.query("select * from Emp99",new RowMapper<Employee>(){  
            public Employee mapRow(ResultSet rs, int row) throws SQLException {  
                Employee e=new Employee();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setDept(rs.getString(3));  
                e.setAge(rs.getInt(4));  
                return e;  
            }  
        });      
    	
    
    }

	


}