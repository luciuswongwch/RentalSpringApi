package com.luciuswong.renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.luciuswong.renting.repository")
@EntityScan("com.luciuswong.renting.model")
public class RentingApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentingApplication.class, args);
	}
}
