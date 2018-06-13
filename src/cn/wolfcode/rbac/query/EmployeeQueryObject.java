package cn.wolfcode.rbac.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeQueryObject extends QueryObject{
	private String keyword;
	private Long deptId = -1L;
}
