package com.dnb.jdbcdemo2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 

@SpringBootApplication // component scan, properties source
public class Jdbcdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Jdbcdemo2Application.class, args);
		System.out.println("Hello");

}

 

}