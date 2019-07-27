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
 * JpaSpecificationExecutorTest������
 * @author Goffy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaSpecificationExecutorTest {
	@Autowired
	private UserDaoJpaSpecificationExecutor userDaoJpaSpecificationExecutor; 
	
	//�����û�������ѯ�û���Ϣ[������]
	@Test
	public void test01() {
		Specification<Users> spec=new Specification<Users>() {
			/**
			 * @author Goffy
			 * @retrun Predicate �����˲�ѯ����
			 * @Param Root<Users> �����󣬷�װ�˲�ѯ�����Ķ���
			 * @Param CriteriaQuery<?> �����˻����Ĳ�ѯ��һ��ʹ�õĲ���
			 * @Param CriteriaBuilder ����һ����ѯ������
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
	
	//��������ѯ[1]ʹ���û����������ѯ����
	@Test
	public void test02() {
		Specification<Users> spec=new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				//����֮��û���κι�ϵ[��Ҫ�����ϵ]
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
	
	//��������ѯ[2]ʹ���û����������ѯ����
	@Test
	public void test03() {
		Specification<Users> spec=new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				/*List<Predicate> predicates = new ArrayList<Predicate>();
				//����֮��û���κι�ϵ[��Ҫ�����ϵ]
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
	
	//��ѯj��ͷ���ҷ�ҳ
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
		System.out.println("������= "+findAll.getTotalElements());
		System.out.println("��ҳ��= "+findAll.getTotalPages());
		List<Users> content = findAll.getContent();
		for (Users users : content) {
			System.out.println(users);
		}
	}
	
	//��ѯ���ݿ���J��ͷ���û������Ұ�id��������
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
	
	//��ѯ���ݿ���J��ͷ���û������Ұ�id��������,��������ҳ����
	
	@Test
	public void test06() {
		
		//��ҳ
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
