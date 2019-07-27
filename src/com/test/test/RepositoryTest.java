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
 * Repository�ӿڲ���
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryTest {
	
	@Autowired
	private UserDaoRepository daoRepository;
	
	//ʹ���û�����Ϊ���ѯ����
	@Test
	public void test01() {
		/**
		 * �ж���ȵĲ�ѯ����
		 * 1��ʲô����д
		 * 2��is
		 * 3��Equal
		 */
		List<Users> findByUsernameIs = this.daoRepository.findByUsernameIs("jordan");
		for (Users users : findByUsernameIs) {
			System.out.println(users);
		}
	}
	
	//ʹ��like��ģ������
	@Test
	public void test02() {
		List<Users> findByUsernameLike = this.daoRepository.findByUsernameLike("%e%");
		for (Users users : findByUsernameLike) {
			System.out.println(users);
		}
	}
	
	//��ѯ����Ϊjordan�����������22��
	@Test
	public void test03() {
		List<Users> findByUsernameAndUserageGreaterThanEqual = this.daoRepository.findByUsernameAndUserageGreaterThanEqual("jordan", 25);
		for (Users users : findByUsernameAndUserageGreaterThanEqual) {			
			System.out.println(users);
		}
	}
	
	//����Queryע���JPQL���
	@Test
	public void test04() {
		List<Users> findByUsernameUseJPQL = this.daoRepository.findByUsernameUseJPQL("jordan");
		for (Users users : findByUsernameUseJPQL) {
			System.out.println(users);
		}
	}
	
	//����Queryע���JPQL���[like]
		@Test
		public void test05() {
			List<Users> findByUsernameLikeUserJPQL = this.daoRepository.findByUsernameLikeUserJPQL("j%");
			for (Users users : findByUsernameLikeUserJPQL) {
				System.out.println(users);
			}
		}
		
	//����Queryע���JPQL��������
		@Test
		public void test06() {
			List<Users> findByUsernameAndUserageThanJPQL = this.daoRepository.findByUsernameAndUserageThanJPQL("jordan", 25);
			for (Users users : findByUsernameAndUserageThanJPQL) {
				System.out.println(users);
			}
		}
	//����Queryע���SQL���
		@Test
		public void test07() {
			List<Users> findByUsernameUseSQL = this.daoRepository.findByUsernameUseSQL("jordan");
			for (Users users : findByUsernameUseSQL) {
				System.out.println(users);
			}
		}
		//����Queryע���SQL���[like]
		@Test
		public void test08() {
			List<Users> findByUsernameLikeUserSQL = this.daoRepository.findByUsernameLikeUserSQL("j%");
			for (Users users : findByUsernameLikeUserSQL) {
				System.out.println(users);
			}
		}
		//����Queryע���SQL���[������]
		@Test
		public void test09() {
			List<Users> findByUsernameAndUserageThanSQL = this.daoRepository.findByUsernameAndUserageThanSQL("jordan", 24);
			for (Users users : findByUsernameAndUserageThanSQL) {
				System.out.println(users);
			}
		}
		
		//����Queryע���JPQL���[����]
		@Test
		@Transactional
		@Rollback(false)
		public void test10() {
			this.daoRepository.updateUserageById(100, 2);
		}

}
