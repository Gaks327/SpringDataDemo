package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pojo.Teacher;
/**
 * 多对多接口
 * @author Goffy
 *
 */

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
