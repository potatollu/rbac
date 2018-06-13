package cn.wolfcode.rbac.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	@RequestMapping("query")
	public String query(Model model,QueryObject qo){
		PageResult result = departmentService.query(qo);
		model.addAttribute("result", result);
		return "department/list";
	}
	@RequestMapping("input")
	public String input(Long id,Model model){
		if (id != null) {
			Department department = departmentService.get(id);
			model.addAttribute("entity", department);
		}
		return "department/input";
	}
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Department entity){
		if (entity.getId() != null) {
			departmentService.update(entity);
		}else{
			departmentService.save(entity);
		}
		return "redirect:/department/query.do";
	}
	@RequestMapping("delete")
	public String delete(Long id){
		if (id != null) {
			departmentService.delete(id);
		}
		return "redirect:/department/query.do";
	}
}
