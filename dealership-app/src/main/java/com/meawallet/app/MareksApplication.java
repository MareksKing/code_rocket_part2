package com.meawallet.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.meawallet")

public class MareksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MareksApplication.class);
	}

}
