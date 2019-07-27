package com.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UsersDao;
import com.test.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test01 {
	
	@Autowired
	private UsersDao usersDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testInsertUsers() {
		Users users = new Users();
		users.setUserage(22);
		users.setUsername("guofei");
		this.usersDao.save(users);
	}
	
	@Test
	public void test01() {
		//org.springframework.data.jpa.repository.support.SimpleJpaRepository@63da207f
		System.out.println(this.usersDao);
		//class com.sun.proxy.$Proxy30基于JDK的动态代理
		System.out.println(this.usersDao.getClass());
	}

}
