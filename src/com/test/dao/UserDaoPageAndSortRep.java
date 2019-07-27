package com.test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.pojo.Users;

public interface UserDaoPageAndSortRep extends PagingAndSortingRepository<Users, Integer> {

}
