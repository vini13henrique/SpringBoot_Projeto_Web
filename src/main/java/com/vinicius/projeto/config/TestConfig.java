package com.vinicius.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.projeto.entities.User;
import com.vinicius.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "vinicius", "vini@", "5445", "321");
		User user2 = new User(null, "henrique", "henrique@", "876690", "123");

		userRepository.saveAll(Arrays.asList(user1, user2));

	}
}
