package com.example.services;

import java.security.SecureRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController{

	//Agent controller variables
	private static final String agent_string = "Hello from Agent endpoint";
	private static final SecureRandom secureRandom = new SecureRandom();
	private final long secureLongId = secureRandom.nextLong() & Long.MAX_VALUE;
	
	//Agent method, returns an Agent with ID and String
	@GetMapping("/agent")
	public Agent agent(){
		return new Agent(secureLongId,agent_string);
	}
}
