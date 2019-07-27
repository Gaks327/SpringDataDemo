package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.pojo.Users;

/**
 * JpaSpecificationExecutor�ӿڵĲ���
 * @author Goffy
 *=====================��������ѯ�Լ���ҳ����Ĵ�������Ѻ�========================
 *=====================���ܵ���ʹ�ã���Ҫ��������ӿ�һͬʹ��=======================
 */
public interface UserDaoJpaSpecificationExecutor extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

	
	
	
}
