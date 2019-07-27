package com.test.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.TeacherDao;
import com.test.dao.UserDaoOneToOne;
import com.test.pojo.Roles;
import com.test.pojo.Student;
import com.test.pojo.Teacher;
import com.test.pojo.Users;

/**
 * ManyToManyTest
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManyToManyTest {
	
	@Autowired
	private TeacherDao teacherDao;
	
	//添加老师和学生
	@Test
	public void test01() {
		//添加老师
		Teacher teacher = new Teacher();
		teacher.setTeaName("赵老师");
		teacher.setTeaStudent("五学生");
		//添加学生
		Student student1 = new Student();
		student1.setStuName("张学生");
		
		Student student2 = new Student();
		student2.setStuName("张学生");
		
		//创建关系
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);
		
		student1.getTeachers().add(teacher);
		student2.getTeachers().add(teacher);
		
		//保存数据
		this.teacherDao.save(teacher);
		
	}
	
	//根据老师
	@Test
	public void test02() {
		Teacher teacher = this.teacherDao.findOne(1);
		System.out.println("老师信息="+teacher);
		Set<Student> students = teacher.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		
	}

}
