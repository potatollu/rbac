package cn.wolfcode.rbac.mapper;

import java.util.List;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;

public interface EmployeeMapper {
	void save(Employee entity);
	void update(Employee entity);
	void delete(Long id);
	Employee get(Long id);
	List<Employee> list();
	
	List<Employee> queryForList(EmployeeQueryObject qo);
	int queryForCount(EmployeeQueryObject qo);
}
