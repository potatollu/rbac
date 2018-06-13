package cn.wolfcode.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.mapper.DepartmentMapper;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public void save(Department entity) {
		departmentMapper.save(entity);
	}

	@Override
	public void update(Department entity) {
		departmentMapper.update(entity);
	}

	@Override
	public void delete(Long id) {
		departmentMapper.delete(id);
	}

	@Override
	public Department get(Long id) {
		return departmentMapper.get(id);
	}

	@Override
	public List<Department> list() {
		return departmentMapper.list();
	}

	@Override
	public PageResult query(QueryObject qo) {
		int count = departmentMapper.queryForCount(qo);
		if (count == 0) {
			return PageResult.EMPTY_PAGERESULT;
		}
		List<?> list = departmentMapper.queryForList(qo);
		return new PageResult(qo.getCurrentPage(),qo.getPageSize(),count,list);
	}
}
