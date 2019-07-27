package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pojo.Users;

/**
 * UserDaoJpaRepository接口的操做
 * @author Goffy
 *	最大的作用是原本将查询全部的返回值Ite返回值做了强转，开发人员不必继续转换
 */
public interface UserDaoJpaRepository extends JpaRepository<Users, Integer> {

	
	
	
}
