package com.rme.admin;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;



@SpringBootApplication

public class CommunityadminApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CommunityadminApplication.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(CommunityadminApplication.class, args);
	}
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory e) {
		return e.getSessionFactory();		
}
	
}
