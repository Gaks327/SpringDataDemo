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
 * PagingAndSortRep测试类
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
		int page=1;//page:当前页的索引，从0开始
		int size=2;//size:每页显示的条数
		Pageable pageable = new PageRequest(page, size);
		Page<Users> findAll = this.userDaoPageAndSortRep.findAll(pageable);
		System.out.println("数据的总条数= "+findAll.getTotalElements());
		System.out.println("数据的总页数= "+findAll.getTotalPages());
		List<Users> content = findAll.getContent();
		for (Users users : content) {
			System.out.println(users);
		}
	}
	
	//单列排序
	@Test
	public void test02() {
		//Sort该对象封装了排序规则以及指定的排序字段（对象的属性表示）
		//Direction：排序的规则[ASC/DESC]
		//properties:指定排序的字段
		Sort sort = new Sort(Direction.DESC,"userId" );
		List<Users> findAll = (List<Users>)this.userDaoPageAndSortRep.findAll(sort);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	//多列排序
	@Test
	public void test03() {
		//Sort该对象封装了排序规则以及指定的排序字段（对象的属性表示）
		//Direction：排序的规则[ASC/DESC]
		//properties:指定排序的字段
		Order order1 = new Order(Direction.DESC,"userage");
		Order order2 = new Order(Direction.ASC,"userId");
		Sort sort = new Sort(order1,order2);
		List<Users> findAll = (List<Users>)this.userDaoPageAndSortRep.findAll(sort);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
}
