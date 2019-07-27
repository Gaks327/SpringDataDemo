package com.test.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="t_student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stuId")
	private Integer stuId;
	@Column(name="stuName")
	private String stuName;
	
	
	//配置多对多关系映射
	@ManyToMany
	//@JoinTable()多对多中间表
	//@JoinColumn建立当前表在中间表中外键字段
	@JoinTable(name="t_stu_tea",joinColumns=@JoinColumn(name="stu_id"),inverseJoinColumns=@JoinColumn(name="tea_id"))
	private Set<Teacher> teachers = new HashSet<>();
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", teachers=" + teachers + "]";
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	

}
