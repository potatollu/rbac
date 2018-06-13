package cn.wolfcode.rbac.service;

import java.util.List;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;

public interface IDepartmentService {
	void save(Department entity);
	void update(Department entity);
	void delete(Long id);
	Department get(Long id);
	List<Department> list();
	
	PageResult query(QueryObject qo);
}
