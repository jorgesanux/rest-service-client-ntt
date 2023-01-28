package com.ex.client.service;

import com.ex.client.exception.ClientNotFoundException;
import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;
import com.ex.client.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findByDocumentAndTypeDocument(String documentNumber, TypeDocument documentType) throws ClientNotFoundException {
        Client client = this.clientRepository
                .findByDocumentAndTypeDocument(documentNumber, documentType)
                .orElseThrow(() -> new ClientNotFoundException(documentNumber, documentType));
        LOGGER.info("Client found");
        return client;
    }
}
