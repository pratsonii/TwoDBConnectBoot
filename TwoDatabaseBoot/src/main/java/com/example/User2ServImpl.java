package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tb2.repo.User2Dao;

@Service
@Transactional()
public class User2ServImpl 
{
	@Autowired
	User2Dao dao;
	
	public String count()
	{
		return ""+dao.count();
	}
}
