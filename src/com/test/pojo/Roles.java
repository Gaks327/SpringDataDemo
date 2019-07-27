package com.test.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_roles")
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid")
	private Integer roleid;
	
	@Column(name="rolename")
	private String rolename;
	
	
public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	/*	//一对一关系映射
	@OneToOne(mappedBy="roles")
	private Users users;
	*/
	@OneToMany(mappedBy="roles")
	
	private Set<Users> users = new HashSet<>();
	
	
	
	
	
	
	

/*	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}*/

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

/*	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", rolename=" + rolename + ", users=" + users + "]";
	}*/
	
	

}
