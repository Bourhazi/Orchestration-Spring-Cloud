package com.example.SERVICE_CLIENT.repositories;

import com.example.SERVICE_CLIENT.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
