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
 * һ��һ������ϵӳ��
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToManyTest {
	
	@Autowired
	private UserDaoOneToOne userDaoOneToOne;
	
	//����û�ͬʱ��ӽ�ɫ
	@Test
	public void test01() {
		Roles roles = new Roles();
		roles.setRolename("�з�");
		//�����û�
		Users users = new Users();
		users.setUserage(48);
		users.setUsername("�����");
		//������ϵ
		roles.getUsers().add(users);
		users.setRoles(roles);
		//��������
		this.userDaoOneToOne.save(users);
	}
	
	//�����û�id��ѯ�û������Ҳ�ѯrole
	@Test
	public void test02() {
		Users users = this.userDaoOneToOne.findOne(13);
		System.out.println("�û�����= "+users.getUsername());
		Roles roles = users.getRoles();
		System.out.println("��ɫ= "+roles.getRolename());
	}

}
