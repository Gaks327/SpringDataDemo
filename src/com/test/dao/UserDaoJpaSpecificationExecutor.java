package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.pojo.Users;

/**
 * JpaSpecificationExecutor接口的操做
 * @author Goffy
 *=====================多条件查询以及分页排序的处理更加友好========================
 *=====================不能单独使用，需要配和其他接口一同使用=======================
 */
public interface UserDaoJpaSpecificationExecutor extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

	
	
	
}
