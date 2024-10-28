package com.gestionAssurance.assurance.services;

import com.gestionAssurance.assurance.entities.Contrat;

import java.util.List;

public interface ContratService {

    Contrat save(Contrat contrat);

    Contrat update(Contrat contrat);

    boolean delete(Long id);

    Contrat findById(Long id);

    List<Contrat> findAll();
}