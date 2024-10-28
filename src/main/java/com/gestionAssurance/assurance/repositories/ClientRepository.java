package com.gestionAssurance.assurance.repositories;


import com.gestionAssurance.assurance.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Additional custom methods can be defined here if necessary
}
