package com.bakkerij_van_blom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"repositories", "controllers", "models"})
public class BakkerijVanBlomApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakkerijVanBlomApplication.class, args);
	}

}
