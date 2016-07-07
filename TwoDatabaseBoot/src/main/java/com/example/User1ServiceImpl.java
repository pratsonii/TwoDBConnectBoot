package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tb1.repo.User1Dao;
@Service
public class User1ServiceImpl 
{
	@Autowired
	User1Dao dao;
	
	public String count()
	{
		return ""+dao.count();
	}
}
