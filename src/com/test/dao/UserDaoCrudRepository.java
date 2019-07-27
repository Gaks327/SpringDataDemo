package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.pojo.Users;

/**
 * CrudRepository接口的操做
 * @author Goffy
 *
 */
public interface UserDaoCrudRepository extends CrudRepository<Users, Integer> {

	
	
	
}
