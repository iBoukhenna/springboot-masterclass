package com.dzcode.springboot.masterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMasterclassApplication {

	public static void main(String[] args) {

		// Loosely coupled : to switch change the algorithm only here
		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		int result  = binarySearch.binarySearch(new int[]{124, 6}, 3);
		System.out.println("the result is : " + result);

		SpringApplication.run(SpringbootMasterclassApplication.class, args);
	}

}
