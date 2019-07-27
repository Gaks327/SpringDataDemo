package com.test.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDaoCrudRepository;
import com.test.pojo.Users;

/**
 * CrudRepository������
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CrudRepositoryTest {
	@Autowired
	private UserDaoCrudRepository userDaoCrudRepository;
	
	//�������
	@Test
	public void test01() {
		Users users = new Users();
		users.setUserage(50);
		users.setUsername("Rose");
		userDaoCrudRepository.save(users);
	}
	
	//�������
	@Test
	public void test02() {
		Users users = new Users();
		users.setUserage(40);
		users.setUsername("Duncan");
		
		Users users2 = new Users();
		users2.setUserage(30);
		users2.setUsername("DeRozan");
		
		List<Users> list = new ArrayList<Users>();
		list.add(users);
		list.add(users2);
		userDaoCrudRepository.save(list);
	}
	
	//��ѯID��ѯ
	@Test
	public void test03() {
		Users findOne = this.userDaoCrudRepository.findOne(3);
		System.out.println(findOne);
		
	}
	
	//��ѯȫ��
	@Test
	public void test04() {
		List<Users> users = (List<Users>)this.userDaoCrudRepository.findAll();
		for (Users users2 : users) {
			System.out.println(users2);
		}
	}
	
	//ɾ��
	@Test
	public void test05() {
		this.userDaoCrudRepository.delete(8);
	}
	
	//��������[1]
	@Test
	public void test06() {
		Users users =this.userDaoCrudRepository.findOne(6);
		users.setUsername("Goffy");
		this.userDaoCrudRepository.save(users);
	}
	
	//��������[2]
	@Test
	@Transactional
	@Rollback(false)
	public void test07() {
		Users users =this.userDaoCrudRepository.findOne(6);//�־û�״̬
		users.setUsername("Rose");
	}
	
	
	

}
