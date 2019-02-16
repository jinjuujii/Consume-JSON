package com.example.demo;

import com.example.jsonFile.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JsonIntoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonIntoDbApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate(); 
		
		//this URL explains how this work. Kinda confusing for me. 
		//https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
		
		ResponseEntity<List<User>> userResponse = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com/users",
				HttpMethod.GET, null, 
				new  ParameterizedTypeReference<List<User>>() {});
		
		List<User> userlists = userResponse.getBody();
		System.out.println(userlists.toString());
		
		
				
 

 
}
}

 