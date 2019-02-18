package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.UserRepository;
import com.example.jsonFile.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRespository;
	
	public void SaveUser (User user) {
		userRespository.save(user);
		
	}

}
