package com.mongodb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
