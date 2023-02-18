package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.jpa.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		logger.info("retrieve person by id 10001 -> {}", userJpaRepository.findById(10001));
	}
}
