package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController 
{
	@Autowired
	User1ServiceImpl serv;
	
	@Autowired
	User2ServImpl serv2;
	
	@RequestMapping("/user1")
	public String user1() 
	{
		return serv.count();
	}
	
	@RequestMapping("/user2")
	public String user2() 
	{
		return serv2.count();
	}
	
	
}
