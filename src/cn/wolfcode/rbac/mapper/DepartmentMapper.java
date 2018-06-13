package cn.wolfcode.rbac.mapper;

import java.util.List;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.QueryObject;

public interface DepartmentMapper {
	void save(Department entity);
	void update(Department entity);
	void delete(Long id);
	Department get(Long id);
	List<Department> list();
	List<Department> queryForList(QueryObject qo);
	int queryForCount(QueryObject qo);
}
