package com.sam.app.services;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sam.app.services.model.User;
import com.sam.app.services.repository.UserRepo;

@Configuration
public class AppInitializer{

	@Bean
	ApplicationRunner init(UserRepo userRepo) {
		
		User a = new User(new BigInteger("1"),"Sam","Mumbai",34);
		User b = new User(new BigInteger("2"),"Deb","Kolkata",41);
		User c = new User(new BigInteger("3"),"Anu","Delhi",13);
		User d = new User(new BigInteger("4"),"Mou","Bangalore",39);
		
		
		List<User> users = Arrays.asList(a,b,c,d);
		
		return args -> {
			userRepo.deleteAll();
			users.stream().forEach(u -> userRepo.save(u));
			userRepo.findAll().forEach(System.out::println);
		};
	}

}
