package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.pojo.Users;

/**
 * CrudRepository�ӿڵĲ���
 * @author Goffy
 *
 */
public interface UserDaoOneToOne extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

	
	
	
}
