package com.example.demo;

import com.example.DAO.UserRepository;
import com.example.jsonFile.*;
import com.example.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableJpaRepositories
public class JsonIntoDbApplication implements CommandLineRunner {

	 
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JsonIntoDbApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		

		RestTemplate restTemplate = new RestTemplate();

		// this URL explains how this work. Kinda confusing for me.
		// https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate

		/*
		 * THIS WORKS ResponseEntity<List<User>> userResponse = restTemplate.exchange(
		 * "https://jsonplaceholder.typicode.com/users", HttpMethod.GET, null, new
		 * ParameterizedTypeReference<List<User>>() {});
		 * 
		 * List<User> userlists = userResponse.getBody();
		 * System.out.println(userlists.toString());
		 */

		// THIS ALSO WORKS
		User[] users = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class);
		List<User> userlists = Arrays.asList(users);
		System.out.println(userlists.toString());

		// TESTING for H2 integration

		for (User x : userlists) {
			userService.SaveUser(x);
		}
	}
}
