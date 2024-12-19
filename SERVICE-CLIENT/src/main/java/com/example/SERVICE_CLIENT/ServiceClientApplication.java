package com.example.SERVICE_CLIENT;

import com.example.SERVICE_CLIENT.entities.Client;
import com.example.SERVICE_CLIENT.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(null, "Hiba EL AMRANI", "hiba@gmail.com", 22));
			clientRepository.save(new Client(null, "Sarah EL AMRANI", "sarah@gmail.com", 27));
		};
	}
}
