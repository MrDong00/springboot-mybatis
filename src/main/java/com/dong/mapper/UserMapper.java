package com.dong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dong.entity.User;

@Mapper
public interface UserMapper{

	@Select("select * from user where name = #{name}")
	User findUserByName(@Param("name") String name);
	
	
	@SelectProvider(type = UserDaoProvider.class, method = "findUserById")  
	public List<User> findUsersById(String id);
	
	class UserDaoProvider {
		public String findUserById(String id) {  
            String sql = "SELECT * FROM user";  
            if(id !=null){  
                sql += " where id = #{id}";  
            }  
            return sql;  
        }  
	}
	
	
	//直接进行关联xml文件
	List<User> findAll();
	
	User findById(String id);
}
