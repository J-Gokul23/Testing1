package com.example.Testing1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Testing1Application {

	public static void main(String[] args) {
		SpringApplication.run(Testing1Application.class, args);

		Calculator calculator = new Calculator();
//		System.out.println(calculator.getException(17));
		System.out.println(calculator.check2(2));
	}


}
