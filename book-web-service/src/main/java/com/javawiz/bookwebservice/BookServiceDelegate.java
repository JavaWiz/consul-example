package com.javawiz.bookwebservice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceDelegate {
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceDelegate.class);
	
	@Autowired
	RestTemplate restTemplate;

	public String getBookById(Long id) {
		log.debug("Consul Demo - Getting books details for " + id);

		String response = restTemplate.exchange("http://book-service//books/{id}",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, id).getBody();

		log.debug("Response Received as " + response + " -  " + new Date());

		return "School Name -  " + id + " :::  book Details " + response + " -  " + new Date();
	}
}