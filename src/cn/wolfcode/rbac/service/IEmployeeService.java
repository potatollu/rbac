package cn.wolfcode.rbac.service;

import java.util.List;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;

public interface IEmployeeService {
	void save(Employee entity);
	void update(Employee entity);
	void delete(Long id);
	Employee get(Long id);
	List<Employee> list();
	
	PageResult query(EmployeeQueryObject qo);
}
