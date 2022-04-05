package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.model.User;
import com.dzcode.springboot.masterclass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMasterclassApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterclassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("admin", "spintechs", "admin@dzcode.com", "213770990021"));
		this.userRepository.save(new User("iboukhenna", "spintechs", "ibrahim.boukhenna@spintechs.net", "213770115081"));
		this.userRepository.save(new User("bibrahim", "spintechs", "boukhenna.ibrahim@gmail.com", "213698706011"));
	}
}
