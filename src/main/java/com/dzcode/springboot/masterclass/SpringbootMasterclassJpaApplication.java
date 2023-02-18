package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.entity.User;
import com.dzcode.springboot.masterclass.jpa.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootMasterclassJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserJpaRepository userJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterclassJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("create -> no of row created - {}", userJpaRepository.create(new User("James", "New York", new Date())));
		logger.info("retrieve person by id 1 -> {}", userJpaRepository.findById(1));
		logger.info("update 1 -> no of row updated - {}", userJpaRepository.update(new User(1, "Ibrahim", "Algiers", new Date())));
		logger.info("delete 1 -> no of row deleted");
		userJpaRepository.deleteById(1);
	}
}
