package com.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Thanges
 *
 */
@RestController
@SpringBootApplication
public class ElasticSearchPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchPocApplication.class, args);
	}
}
