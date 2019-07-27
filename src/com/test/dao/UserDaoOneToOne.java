package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.pojo.Users;

/**
 * CrudRepository接口的操做
 * @author Goffy
 *
 */
public interface UserDaoOneToOne extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

	
	
	
}
