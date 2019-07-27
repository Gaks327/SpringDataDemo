package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pojo.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {
	

}
