package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.UserMapper;
import com.example.model.Users;

@RestController
@RequestMapping("/demo")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/user/{id}")
	public Users getUser(@PathVariable Long id, HttpSession session) {
		Users u = userMapper.getOne(id);
		session.setAttribute("name", "anna");
		System.out.println(session.getId());
		return u;
	}
}
