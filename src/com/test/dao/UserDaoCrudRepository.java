package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.pojo.Users;

/**
 * CrudRepository�ӿڵĲ���
 * @author Goffy
 *
 */
public interface UserDaoCrudRepository extends CrudRepository<Users, Integer> {

	
	
	
}
