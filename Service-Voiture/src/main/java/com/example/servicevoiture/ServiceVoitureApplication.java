package com.example.servicevoiture;

import com.example.servicevoiture.entities.Client;
import com.example.servicevoiture.entities.Voiture;
import com.example.servicevoiture.repositories.VoitureRepository;
import com.example.servicevoiture.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients

@SpringBootApplication
public class ServiceVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }
    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
            return args -> {
                try {
                    Client c1 = clientService.getClientById(2L);
                    Client c2 = clientService.getClientById(1L);

                    voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, null));
                    voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 1L, null));
                    voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L, null));
                } catch (Exception e) {
                    System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
                }
            };
        }

}
