package com.example.MyTools.repository;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.Client;
import com.example.MyTools.model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByEmailAndPassword(String email, String password);

    Optional<Client> findClientByContacts(String contact);
    Optional<Client> findByEmail(String email);
}
