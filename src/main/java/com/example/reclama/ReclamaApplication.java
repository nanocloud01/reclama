package com.example.reclama;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReclamaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReclamaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i <= 5; i++) {
			System.out.println((6 - i - 1) + " :....");
		}
	}

}
