package com.gestionAssurance.assurance.services;

import com.gestionAssurance.assurance.entities.Assurance;
import java.util.List;

public interface AssuranceService {

    Assurance save(Assurance assurance);

    Assurance update(Assurance assurance);

    boolean delete(Long id);

    Assurance findById(Long id);

    List<Assurance> findAll();
}