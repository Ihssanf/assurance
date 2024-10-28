package com.gestionAssurance.assurance.services;

import com.gestionAssurance.assurance.entities.Contrat;
import com.gestionAssurance.assurance.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Contrat save(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat update(Contrat contrat) {
        if (contratRepository.existsById(contrat.getId())) {
            return contratRepository.save(contrat);
        }
        return null; // Return null or throw an exception if not found
    }

    @Override
    public boolean delete(Long id) {
        if (contratRepository.existsById(id)) {
            contratRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Contrat findById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }
}