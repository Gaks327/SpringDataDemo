package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pojo.Users;

/**
 * UserDaoJpaRepository�ӿڵĲ���
 * @author Goffy
 *	����������ԭ������ѯȫ���ķ���ֵIte����ֵ����ǿת��������Ա���ؼ���ת��
 */
public interface UserDaoJpaRepository extends JpaRepository<Users, Integer> {

	
	
	
}
