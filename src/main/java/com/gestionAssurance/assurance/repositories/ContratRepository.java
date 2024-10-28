package com.gestionAssurance.assurance.repositories;

import com.gestionAssurance.assurance.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}