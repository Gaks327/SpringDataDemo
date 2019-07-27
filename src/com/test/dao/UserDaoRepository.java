package com.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.test.pojo.Users;

/**
 * �̳�Repository�ӿڵķ���
 * @author Goffy
 *
 */
public interface UserDaoRepository extends Repository<Users, Integer> {

	//�������Ʋ�ѯ
	List<Users> findByUsernameIs(String string);

	List<Users> findByUsernameLike(String string);
	
	List<Users> findByUsernameAndUserageGreaterThanEqual(String usernmae,Integer userage);
	
	
	//@Queryע���ѯ
	@Query(value="from Users where username = ?")//������������������ΰ�
	List<Users> findByUsernameUseJPQL(String username);
	
	@Query(value="from Users where username like ?")
	List<Users> findByUsernameLikeUserJPQL(String Username);
	
	@Query(value="from Users where username = ? and userage > ?")
	List<Users> findByUsernameAndUserageThanJPQL(String Username,Integer userage);
	
	
	//ʹ��queryע�����SQL
	//nativeQuery:Ĭ��Ϊfalse,��ʾ������sql��ѯ,�Ƿ��value�е�ֵ��ת��
	@Query(value="select * from t_users where username = ?",nativeQuery=true)//������������������ΰ�
	List<Users> findByUsernameUseSQL(String username);
	
	@Query(value="select * from t_users where username like ?",nativeQuery=true)
	List<Users> findByUsernameLikeUserSQL(String Username);
	
	@Query(value="select * from t_users where username = ? and userage > ?",nativeQuery=true)
	List<Users> findByUsernameAndUserageThanSQL(String Username,Integer userage);
	
	
	//ʹ��queryע����ɸ��²���
	@Query("update Users set userage = ? where userId = ? ")
	@Modifying//@Modifying��ʾ����һ�����²���
	void updateUserageById(Integer userage,Integer id);
	
}
