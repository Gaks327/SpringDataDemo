package com.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.test.pojo.Users;

/**
 * 继承Repository接口的方法
 * @author Goffy
 *
 */
public interface UserDaoRepository extends Repository<Users, Integer> {

	//方法名称查询
	List<Users> findByUsernameIs(String string);

	List<Users> findByUsernameLike(String string);
	
	List<Users> findByUsernameAndUserageGreaterThanEqual(String usernmae,Integer userage);
	
	
	//@Query注解查询
	@Query(value="from Users where username = ?")//多个参数从左至右依次绑定
	List<Users> findByUsernameUseJPQL(String username);
	
	@Query(value="from Users where username like ?")
	List<Users> findByUsernameLikeUserJPQL(String Username);
	
	@Query(value="from Users where username = ? and userage > ?")
	List<Users> findByUsernameAndUserageThanJPQL(String Username,Integer userage);
	
	
	//使用query注解基于SQL
	//nativeQuery:默认为false,表示不开启sql查询,是否对value中的值做转义
	@Query(value="select * from t_users where username = ?",nativeQuery=true)//多个参数从左至右依次绑定
	List<Users> findByUsernameUseSQL(String username);
	
	@Query(value="select * from t_users where username like ?",nativeQuery=true)
	List<Users> findByUsernameLikeUserSQL(String Username);
	
	@Query(value="select * from t_users where username = ? and userage > ?",nativeQuery=true)
	List<Users> findByUsernameAndUserageThanSQL(String Username,Integer userage);
	
	
	//使用query注解完成更新操作
	@Query("update Users set userage = ? where userId = ? ")
	@Modifying//@Modifying表示这是一个更新操作
	void updateUserageById(Integer userage,Integer id);
	
}
