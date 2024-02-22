package com.sai.samithi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SamithiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamithiApplication.class, args);
	}

}
