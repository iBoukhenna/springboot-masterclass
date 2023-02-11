package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootMasterclassScopeApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(SpringbootMasterclassScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringbootMasterclassScopeApplication.class, args);
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);

		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		LOGGER.info("{}", personDAO.getJdbcConnection());
		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO2.getJdbcConnection());
	}

}
