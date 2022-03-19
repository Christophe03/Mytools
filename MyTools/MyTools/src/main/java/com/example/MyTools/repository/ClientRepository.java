package com.example.MyTools.repository;

import com.example.MyTools.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByEmailAndPassword(String email, String password);

    Optional<Client> findClientByContacts(String contact);
    Optional<Client> findByEmail(String email);
}
