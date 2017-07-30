package com.example.demo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private com.example.mapper.UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new Users());

		//Assert.assertEquals(6, UserMapper.getAll().size());
	}
	
	@Test
    public void testQuery() throws Exception {
        List<Users> users = UserMapper.getAll();
        System.out.println(users.get(0).getName());
    }

}
