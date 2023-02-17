package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootMasterclassCdiApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(SpringbootMasterclassCdiApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringbootMasterclassCdiApplication.class, args);
		SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);

		LOGGER.info("{} dao-{}", someCdiBusiness, someCdiBusiness.getSomeCdiDao());
	}

}
