package com.gestionAssurance.assurance.repositories;

import com.gestionAssurance.assurance.entities.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Long> {
    // You can add custom methods if necessary
}