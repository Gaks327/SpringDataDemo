package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pojo.Teacher;
/**
 * ��Զ�ӿ�
 * @author Goffy
 *
 */

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
