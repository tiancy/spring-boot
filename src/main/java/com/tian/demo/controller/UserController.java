package com.tian.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tian.demo.mapper.UserMapper;
import com.tian.demo.model.Users;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/get/{id}")
	@Cacheable(value="users", key="'demo:user:'+#id")
	public Users getUser(@PathVariable Long id, HttpSession session) {
		Users user = userMapper.getOne(id);
		
		System.out.println(session.getId());
		return user;
	}
	
	@RequestMapping("/delete/{id}")
	@CacheEvict(value="user", key="'demo:user:'+#id")
	public String delete(@PathVariable Long id) {
		userMapper.delete(id);
		return "success";
	}
	
	@RequestMapping("/deleteAll")
	@CacheEvict(value="user", allEntries=true)
	public String deleteAll() {
		userMapper.deleteAll();
		return "success";
	}
}
