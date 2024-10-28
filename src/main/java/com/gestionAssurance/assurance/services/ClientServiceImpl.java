package com.gestionAssurance.assurance.services;

import com.gestionAssurance.assurance.entities.Client;
import com.gestionAssurance.assurance.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        if (clientRepository.existsById(client.getId())) {
            return clientRepository.save(client);
        }
        return null; // Return null or throw an exception if not found
    }

    @Override
    public boolean delete(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}