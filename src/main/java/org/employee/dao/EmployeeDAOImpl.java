package org.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	JdbcTemplate template;

	public int saveEmployee(Employee employee) {

		String sql = "insert into EMPLOYEE(id,name,dept,age) values(" + employee.getId() + ",'"
				+ employee.getName() + "','" + employee.getDept() + "'," + employee.getAge() + ")";
		return template.update(sql);

	}

	public List<Employee> getAllEmployees() {
		return template.query("select * from EMPLOYEE", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDept(rs.getString(3));
				e.setAge(rs.getInt(4));
				return e;
			}
		});

	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql="select * from Employee where id=?"; 
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

}
