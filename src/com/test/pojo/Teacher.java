package com.test.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacherId")
	private Integer teacherId;
	
	@Column(name="teaName")
	private String teaName;
	
	@Column(name="teaStudent")
	private String teaStudent;
	
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	//配置多对多关系映射
	@ManyToMany(mappedBy="teachers",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Student> students = new HashSet<>();


	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeaName() {
		return teaName;
	}



	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teaName=" + teaName + ", teaStudent=" + teaStudent + ", students="
				+ students + "]";
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaStudent() {
		return teaStudent;
	}

	public void setTeaStudent(String teaStudent) {
		this.teaStudent = teaStudent;
	}
	
	

}
