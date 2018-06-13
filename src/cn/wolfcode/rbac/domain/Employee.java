package cn.wolfcode.rbac.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends BaseDomain{
	private String name;
	private String password;
	private String email;
	private Integer age;
	private boolean admin;
	private Department dept; 
}
