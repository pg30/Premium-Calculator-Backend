package com.pg.premiumcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pg.premiumcalculator.repository")
public class PremiumCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PremiumCalculatorApplication.class, args);
	}
	
}
