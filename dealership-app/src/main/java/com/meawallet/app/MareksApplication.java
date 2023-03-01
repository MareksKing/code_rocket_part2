package com.meawallet.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication(scanBasePackages = "com.meawallet",
		exclude = HibernateJpaAutoConfiguration.class)
public class MareksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MareksApplication.class);
	}

}
