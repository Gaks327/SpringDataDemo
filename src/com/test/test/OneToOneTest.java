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
public class OneToOneTest {
	
	@Autowired
	private UserDaoOneToOne userDaoOneToOne;
	
	//����û�ͬʱ��ӽ�ɫ
	/*@Test
	public void test01() {
		//������ɫ
		Roles roles = new Roles();
		roles.setRolename("�÷ֺ���");
		//�����û�
		Users users = new Users();
		users.setUserage(30);
		users.setUsername("��������");
		//������ϵ
		users.setRoles(roles);
		roles.setUsers(users);
		//��������
		this.userDaoOneToOne.save(users);
	}*/
	
	//�����û�id��ѯ�û������Ҳ�ѯrole
	/*@Test
	public void test02() {
		Users users = this.userDaoOneToOne.findOne(12);
		System.out.println("�û���Ϣ= "+users);
		Roles roles = users.getRoles();
		System.out.println("��ɫ��Ϣ= "+roles);
	}*/

}
