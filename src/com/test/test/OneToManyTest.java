package com.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.UserDaoOneToOne;
import com.test.pojo.Roles;
import com.test.pojo.Users;

/**
 * 一对一关联关系映射
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToManyTest {
	
	@Autowired
	private UserDaoOneToOne userDaoOneToOne;
	
	//添加用户同时添加角色
	@Test
	public void test01() {
		Roles roles = new Roles();
		roles.setRolename("中锋");
		//创建用户
		Users users = new Users();
		users.setUserage(48);
		users.setUsername("奥尼尔");
		//建立联系
		roles.getUsers().add(users);
		users.setRoles(roles);
		//保存数据
		this.userDaoOneToOne.save(users);
	}
	
	//根据用户id查询用户，并且查询role
	@Test
	public void test02() {
		Users users = this.userDaoOneToOne.findOne(13);
		System.out.println("用户姓名= "+users.getUsername());
		Roles roles = users.getRoles();
		System.out.println("角色= "+roles.getRolename());
	}

}
