package com.gestion.assurance.services;

import com.gestion.assurance.entities.Assurance;
import java.util.List;

public interface AssuranceService {

    Assurance save(Assurance assurance);

    Assurance update(Assurance assurance);

    boolean delete(Long id); // Returns true if deletion was successful, false otherwise

    Assurance findById(Long id);

    List<Assurance> findAll();
}