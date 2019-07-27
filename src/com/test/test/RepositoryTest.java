package com.test.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDaoRepository;
import com.test.pojo.Users;

/**
 * Repository接口测试
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryTest {
	
	@Autowired
	private UserDaoRepository daoRepository;
	
	//使用用户名作为拆查询条件
	@Test
	public void test01() {
		/**
		 * 判断相等的查询条件
		 * 1、什么都不写
		 * 2、is
		 * 3、Equal
		 */
		List<Users> findByUsernameIs = this.daoRepository.findByUsernameIs("jordan");
		for (Users users : findByUsernameIs) {
			System.out.println(users);
		}
	}
	
	//使用like做模糊查找
	@Test
	public void test02() {
		List<Users> findByUsernameLike = this.daoRepository.findByUsernameLike("%e%");
		for (Users users : findByUsernameLike) {
			System.out.println(users);
		}
	}
	
	//查询名称为jordan并且年龄大于22的
	@Test
	public void test03() {
		List<Users> findByUsernameAndUserageGreaterThanEqual = this.daoRepository.findByUsernameAndUserageGreaterThanEqual("jordan", 25);
		for (Users users : findByUsernameAndUserageGreaterThanEqual) {			
			System.out.println(users);
		}
	}
	
	//测试Query注解的JPQL语句
	@Test
	public void test04() {
		List<Users> findByUsernameUseJPQL = this.daoRepository.findByUsernameUseJPQL("jordan");
		for (Users users : findByUsernameUseJPQL) {
			System.out.println(users);
		}
	}
	
	//测试Query注解的JPQL语句[like]
		@Test
		public void test05() {
			List<Users> findByUsernameLikeUserJPQL = this.daoRepository.findByUsernameLikeUserJPQL("j%");
			for (Users users : findByUsernameLikeUserJPQL) {
				System.out.println(users);
			}
		}
		
	//测试Query注解的JPQL语句多条件
		@Test
		public void test06() {
			List<Users> findByUsernameAndUserageThanJPQL = this.daoRepository.findByUsernameAndUserageThanJPQL("jordan", 25);
			for (Users users : findByUsernameAndUserageThanJPQL) {
				System.out.println(users);
			}
		}
	//测试Query注解的SQL语句
		@Test
		public void test07() {
			List<Users> findByUsernameUseSQL = this.daoRepository.findByUsernameUseSQL("jordan");
			for (Users users : findByUsernameUseSQL) {
				System.out.println(users);
			}
		}
		//测试Query注解的SQL语句[like]
		@Test
		public void test08() {
			List<Users> findByUsernameLikeUserSQL = this.daoRepository.findByUsernameLikeUserSQL("j%");
			for (Users users : findByUsernameLikeUserSQL) {
				System.out.println(users);
			}
		}
		//测试Query注解的SQL语句[多条件]
		@Test
		public void test09() {
			List<Users> findByUsernameAndUserageThanSQL = this.daoRepository.findByUsernameAndUserageThanSQL("jordan", 24);
			for (Users users : findByUsernameAndUserageThanSQL) {
				System.out.println(users);
			}
		}
		
		//测试Query注解的JPQL语句[更新]
		@Test
		@Transactional
		@Rollback(false)
		public void test10() {
			this.daoRepository.updateUserageById(100, 2);
		}

}
