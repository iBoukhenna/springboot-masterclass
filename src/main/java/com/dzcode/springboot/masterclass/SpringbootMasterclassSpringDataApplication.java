package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.entity.Employe;
import com.dzcode.springboot.masterclass.springdata.EmployeSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootMasterclassSpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeSpringDataRepository employeSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterclassSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("create -> no of row created - {}", employeSpringDataRepository.save(new Employe("James", "New York", new Date())));
		logger.info("retrieve person by id 1 -> {}", employeSpringDataRepository.findById(1));
		logger.info("update 1 -> no of row updated - {}", employeSpringDataRepository.save(new Employe(1, "Ibrahim", "Algiers", new Date())));
		logger.info("All employes -> {}", employeSpringDataRepository.findAll());
		logger.info("delete 1 -> no of row deleted");
		employeSpringDataRepository.deleteById(1);
	}
}
