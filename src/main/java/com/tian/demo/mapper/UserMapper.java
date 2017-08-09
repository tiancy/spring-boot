package com.tian.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tian.demo.model.Users;

public interface UserMapper {
	
	@Select("SELECT * FROM users")
    @Results({
        @Result(property = "nickName", column = "nick_name")
    })
    List<Users> getAll();
     
    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
        @Result(property = "nickName", column = "nick_name")
    })
    Users getOne(Long id);
 
    @Insert("INSERT INTO users(name,password,sex) VALUES(#{name}, #{password}, #{sex})")
    void insert(Users user);
 
    @Update("UPDATE users SET name=#{name},nick_name=#{nickName} WHERE id =#{id}")
    void update(Users user);
 
    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
