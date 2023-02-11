package com.dzcode.springboot.masterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootMasterclassApplication {

	// What are the beans ? -> @Component
	// What are the dependencies of bean ? -> @Autowired
	// Where to search for beans ? -> in this package with @ComponentScan in @SpringBootApplication
	// Where would all these beans be managed ? -> in SpringApplicationContext
	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringbootMasterclassApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);

		// Default Bean scope is singleton
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		// Loosely coupled : to switch change the algorithm only here
		// only one algorithm is enable to be bean with @Component
		int result  = binarySearch.binarySearch(new int[]{124, 6}, 3);
		System.out.println("the result is : " + result);
	}

}
