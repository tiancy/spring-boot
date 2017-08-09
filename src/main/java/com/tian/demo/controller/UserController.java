package com.tian.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tian.demo.mapper.UserMapper;
import com.tian.demo.model.Users;

@RestController
@RequestMapping("/demo")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/user/{id}")
	@Cacheable(value="demo-user")
	public Users getUser(@PathVariable Long id, HttpSession session) {
		Users u = userMapper.getOne(id);
		
		System.out.println(session.getId());
		return u;
	}
}
