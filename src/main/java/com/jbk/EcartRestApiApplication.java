package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("xyz")   used to store object of class of another package
public class EcartRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcartRestApiApplication.class, args);
	}

}
