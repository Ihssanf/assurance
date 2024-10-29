package com.gestion.assurance.repositories;

import com.gestion.assurance.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {

    @Query("SELECT c FROM Contrat c WHERE c.assurance.id = :assuranceId")
    List<Contrat> findByAssuranceId(@Param("assuranceId") Long assuranceId);
}   