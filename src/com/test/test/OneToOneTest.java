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
public class OneToOneTest {
	
	@Autowired
	private UserDaoOneToOne userDaoOneToOne;
	
	//添加用户同时添加角色
	/*@Test
	public void test01() {
		//创建角色
		Roles roles = new Roles();
		roles.setRolename("得分后卫");
		//创建用户
		Users users = new Users();
		users.setUserage(30);
		users.setUsername("扎克拉文");
		//建立联系
		users.setRoles(roles);
		roles.setUsers(users);
		//保存数据
		this.userDaoOneToOne.save(users);
	}*/
	
	//根据用户id查询用户，并且查询role
	/*@Test
	public void test02() {
		Users users = this.userDaoOneToOne.findOne(12);
		System.out.println("用户信息= "+users);
		Roles roles = users.getRoles();
		System.out.println("角色信息= "+roles);
	}*/

}
