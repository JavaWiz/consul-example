package com.javawiz.bookwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BookWebServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceDelegate.class);
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookWebServiceApplication.class, args);
	}

	@Autowired
	BookServiceDelegate bookServiceDelegate;

	@GetMapping("/books/{id}")
	public String getStudents(@PathVariable Long id) {
		log.debug("Going to call book service to get data!");
		return bookServiceDelegate.getBookById(id);
	}

}
