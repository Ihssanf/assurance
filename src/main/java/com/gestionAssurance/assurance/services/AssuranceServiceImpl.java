package com.gestionAssurance.assurance.services;

import com.gestionAssurance.assurance.entities.Assurance;
import com.gestionAssurance.assurance.repositories.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    @Override
    public Assurance save(Assurance assurance) {
        System.out.println("Saving assurance: " + assurance); // Debug statement
        return assuranceRepository.save(assurance);
    }

    @Override
    public Assurance update(Assurance assurance) {
        if (assuranceRepository.existsById(assurance.getId())) {
            return assuranceRepository.save(assurance);
        }
        return null; // Return null or throw an exception if not found
    }

    @Override
    public boolean delete(Long id) {
        if (assuranceRepository.existsById(id)) {
            assuranceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Assurance findById(Long id) {
        return assuranceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Assurance> findAll() {
        return assuranceRepository.findAll();
    }
}