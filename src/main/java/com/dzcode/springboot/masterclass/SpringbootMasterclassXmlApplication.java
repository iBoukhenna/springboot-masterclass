package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.scope.PersonDAO;
import com.dzcode.springboot.masterclass.xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
public class SpringbootMasterclassXmlApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(SpringbootMasterclassXmlApplication.class);

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			XmlPersonDAO xmlpersonDAO = applicationContext.getBean(XmlPersonDAO.class);

			LOGGER.info("{}", xmlpersonDAO);
		}
	}

}
