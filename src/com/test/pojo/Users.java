package com.test.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_users")//name为数据库表名
public class Users  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(name="userid")
	private Integer userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="userage")
	private Integer userage;
	
	
/*	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}*/

	/*//一对一关系映射
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="roles_id")//维护一个外键
	private Roles roles;*/
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="roles_id")
	private Roles roles;
	
	

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserage() {
		return userage;
	}

	public void setUserage(Integer userage) {
		this.userage = userage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", userage=" + userage + "]";
	}
	
	
	

}
