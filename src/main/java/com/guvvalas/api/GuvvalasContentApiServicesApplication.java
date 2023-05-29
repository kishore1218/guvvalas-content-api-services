package com.guvvalas.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication
public class GuvvalasContentApiServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuvvalasContentApiServicesApplication.class, args);
	}

}
