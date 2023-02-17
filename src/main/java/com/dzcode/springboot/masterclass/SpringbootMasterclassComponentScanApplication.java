package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dzcode.springboot.componentscan")
public class SpringbootMasterclassComponentScanApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(SpringbootMasterclassComponentScanApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringbootMasterclassComponentScanApplication.class, args);
		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

		LOGGER.info("{}", componentDAO);
	}

}
