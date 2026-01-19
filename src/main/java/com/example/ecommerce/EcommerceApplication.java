package com.example.ecommerce;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8081"); // Force Port 8081
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public MongoClient mongoClient() {
		String uri = "mongodb+srv://tanishq2127tanishq_db_user:BwdJokxtYevkHwEv@cluster0.ghrs5cr.mongodb.net/ecommerce_db";
		ConnectionString connectionString = new ConnectionString(uri);
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(settings);
	}
}