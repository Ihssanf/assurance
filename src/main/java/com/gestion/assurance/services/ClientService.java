package com.gestion.assurance.services;


import com.gestion.assurance.entities.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    Client update(Client client);

    boolean delete(Long id);

    Client findById(Long id);

    List<Client> findAll();
}
