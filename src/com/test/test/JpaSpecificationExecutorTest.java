package com.test.test;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.UserDaoJpaSpecificationExecutor;
import com.test.pojo.Users;

/**
 * JpaSpecificationExecutorTest测试类
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaSpecificationExecutorTest {
	@Autowired
	private UserDaoJpaSpecificationExecutor userDaoJpaSpecificationExecutor; 
	
	//根据用户姓名查询用户信息[单条件]
	@Test
	public void test01() {
		Specification<Users> spec=new Specification<Users>() {
			/**
			 * @author Goffy
			 * @retrun Predicate 定义了查询条件
			 * @Param Root<Users> 根对象，封装了查询条件的对象
			 * @Param CriteriaQuery<?> 定义了基本的查询，一般使用的不多
			 * @Param CriteriaBuilder 创建一个查询的条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate equal = cb.equal(root.get("username"), "jordan");
				return equal;
			}
		};
		List<Users> findAll = this.userDaoJpaSpecificationExecutor.findAll(spec);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	//多条件查询[1]使用用户姓名年龄查询并且
	@Test
	public void test02() {
		Specification<Users> spec=new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				//条件之间没有任何关系[需要定义关系]
				predicates.add(arg2.equal(arg0.get("username"), "jordan"));
				predicates.add(arg2.equal(arg0.get("userage"), 100));
				Predicate [] predicates2 = new Predicate[predicates.size()];
				Predicate and = arg2.and(predicates.toArray(predicates2));
				return and;
			}
		};
		List<Users> findAll = this.userDaoJpaSpecificationExecutor.findAll(spec);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	//多条件查询[2]使用用户姓名年龄查询或者
	@Test
	public void test03() {
		Specification<Users> spec=new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				/*List<Predicate> predicates = new ArrayList<Predicate>();
				//条件之间没有任何关系[需要定义关系]
				predicates.add(arg2.equal(arg0.get("username"), "jordan"));
				predicates.add(arg2.equal(arg0.get("userage"), 100));
				Predicate [] predicates2 = new Predicate[predicates.size()];
				Predicate and = arg2.and(predicates.toArray(predicates2));*/
				return arg2.or(arg2.equal(arg0.get("username"),"jordan"),arg2.equal(arg0.get("userage"),100));
			}
		};	
		List<Users> findAll = this.userDaoJpaSpecificationExecutor.findAll(spec);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	//查询j开头并且分页
	@Test
	public void test04() {
		//spec
		Specification<Users> spec = new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				return arg2.like(arg0.get("username").as(String.class), "j%");
			}
		};
		//page
		Pageable page = new PageRequest(1, 2);
		Page<Users> findAll = this.userDaoJpaSpecificationExecutor.findAll(spec, page);
		for (Users users : findAll) {
			System.out.println(users);
		}
		System.out.println("总条数= "+findAll.getTotalElements());
		System.out.println("总页数= "+findAll.getTotalPages());
		List<Users> content = findAll.getContent();
		for (Users users : content) {
			System.out.println(users);
		}
	}
	
	//查询数据库中J开头的用户，并且按id做降序处理
	@Test
	public void test05() {
		Specification<Users> spec = new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				return arg2.like(arg0.get("username").as(String.class), "j%");
			}
		};
		Sort sort = new Sort(Direction.DESC,"userId");
		List<Users> findAll = this.userDaoJpaSpecificationExecutor.findAll(spec, sort);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	//查询数据库中J开头的用户，并且按id做降序处理,并且做分页处理
	
	@Test
	public void test06() {
		
		//分页
		Sort sort = new Sort(Direction.DESC,"userId");
		Pageable pageable = new PageRequest(1, 2, sort);
		Specification<Users> spec = new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				return arg2.like(arg0.get("username").as(String.class), "j%");
				}
			};
		Page<Users> findAll = this.userDaoJpaSpecificationExecutor.findAll(spec, pageable);
		for (Users users : findAll) {
			System.out.println(users);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
