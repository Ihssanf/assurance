package com.gestion.assurance.services;

import com.gestion.assurance.repositories.AssuranceRepository;
import com.gestion.assurance.repositories.ContratRepository;
import com.gestion.assurance.entities.Assurance;
import com.gestion.assurance.entities.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    @Autowired
    private ContratRepository contratRepository;

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
    @Transactional
    public boolean delete(Long id) {
        if (assuranceRepository.existsById(id)) {
            // Find contracts associated with the insurance
            List<Contrat> contracts = contratRepository.findByAssuranceId(id);

            // Delete the contracts (or update them if necessary)
            contracts.forEach(contratRepository::delete);

            // Now delete the insurance
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