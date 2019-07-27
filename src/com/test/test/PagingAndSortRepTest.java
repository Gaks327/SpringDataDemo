package com.test.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.UserDaoPageAndSortRep;
import com.test.pojo.Users;

/**
 * PagingAndSortRep������
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PagingAndSortRepTest {

	@Autowired
	private UserDaoPageAndSortRep userDaoPageAndSortRep;
	
	@Test
	public void test01() {
		int page=1;//page:��ǰҳ����������0��ʼ
		int size=2;//size:ÿҳ��ʾ������
		Pageable pageable = new PageRequest(page, size);
		Page<Users> findAll = this.userDaoPageAndSortRep.findAll(pageable);
		System.out.println("���ݵ�������= "+findAll.getTotalElements());
		System.out.println("���ݵ���ҳ��= "+findAll.getTotalPages());
		List<Users> content = findAll.getContent();
		for (Users users : content) {
			System.out.println(users);
		}
	}
	
	//��������
	@Test
	public void test02() {
		//Sort�ö����װ����������Լ�ָ���������ֶΣ���������Ա�ʾ��
		//Direction������Ĺ���[ASC/DESC]
		//properties:ָ��������ֶ�
		Sort sort = new Sort(Direction.DESC,"userId" );
		List<Users> findAll = (List<Users>)this.userDaoPageAndSortRep.findAll(sort);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	//��������
	@Test
	public void test03() {
		//Sort�ö����װ����������Լ�ָ���������ֶΣ���������Ա�ʾ��
		//Direction������Ĺ���[ASC/DESC]
		//properties:ָ��������ֶ�
		Order order1 = new Order(Direction.DESC,"userage");
		Order order2 = new Order(Direction.ASC,"userId");
		Sort sort = new Sort(order1,order2);
		List<Users> findAll = (List<Users>)this.userDaoPageAndSortRep.findAll(sort);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
}
