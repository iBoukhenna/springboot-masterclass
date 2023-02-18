package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.entity.Person;
import com.dzcode.springboot.masterclass.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringbootMasterclassApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterclassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All persons -> {}", personJdbcDao.findAll());
		logger.info("create 10004 -> no of row created - {}", personJdbcDao.create(new Person(10004, "James", "New York", new Date())));
		logger.info("retrieve person by id 10001 -> {}", personJdbcDao.findById(10001));
		logger.info("update 10003 -> no of row updated - {}", personJdbcDao.update(new Person(10003, "Ibrahim", "Algiers", new Date())));
		logger.info("delete 10002 -> no of row deleted - {}", personJdbcDao.deleteById(10002));
	}
}
