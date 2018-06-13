package cn.wolfcode.rbac.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.service.IEmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IDepartmentService departmentService;
	@RequestMapping("query")
	public String query(Model model,@ModelAttribute("qo")EmployeeQueryObject qo){
		List<Department> list = departmentService.list();
		model.addAttribute("depts", list);
		PageResult result = employeeService.query(qo);
		model.addAttribute("result", result);
		return "employee/list";
	}
	@RequestMapping("input")
	public String input(Long id,Model model){
		List<Department> list = departmentService.list();
		model.addAttribute("depts", list);
		if (id != null) {
			Employee employee = employeeService.get(id);
			model.addAttribute("entity", employee);
		}
		return "employee/input";
	}
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Employee entity){
		if (entity.getId() != null) {
			employeeService.update(entity);
		}else{
			employeeService.save(entity);
		}
		return "redirect:/employee/query.do";
	}
	@RequestMapping("delete")
	public String delete(Long id){
		if (id != null) {
			employeeService.delete(id);
		}
		return "redirect:/employee/query.do";
	}
}
