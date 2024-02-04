package com.muabatech.mongospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.muabatech.mongospring.product.Product;
import com.muabatech.mongospring.product.ProductRepository;

@SpringBootApplication
public class MongospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongospringApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository repository
			) {
		return args -> {
			var product = Product.builder()
					.name("iPhone")
					.description("Smart Phone")
					.build();
			repository.insert(product);
		};
	}

}
