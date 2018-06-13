package cn.wolfcode.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private EmployeeMapper employeeMapper;
	@Override
	public void save(Employee entity) {
		employeeMapper.save(entity);
	}

	@Override
	public void update(Employee entity) {
		employeeMapper.update(entity);
	}

	@Override
	public void delete(Long id) {
		employeeMapper.delete(id);
	}

	@Override
	public Employee get(Long id) {
		return employeeMapper.get(id);
	}

	@Override
	public List<Employee> list() {
		return employeeMapper.list();
	}

	@Override
	public PageResult query(EmployeeQueryObject qo) {
		int count = employeeMapper.queryForCount(qo);
		if (count == 0) {
			return PageResult.EMPTY_PAGERESULT;
		}
		List<?> list = employeeMapper.queryForList(qo);
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, list);
	}

}
