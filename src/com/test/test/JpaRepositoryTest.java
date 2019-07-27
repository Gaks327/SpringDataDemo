package com.test.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.UserDaoJpaRepository;
import com.test.pojo.Users;
/**
 * JpaRepository接口测试
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaRepositoryTest {
	
	@Autowired
	private UserDaoJpaRepository userDaoJpaRepository;
	
	
	//查询全部
	@Test
	public void test01() {
		List<Users> findAll = this.userDaoJpaRepository.findAll();
		for (Users users : findAll) {
			System.out.println(users);
		}
	}

}
