package com.ex.client.repository;

import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRepository.class);
    private static List<Client> clients = new ArrayList<>();

    static {
        LOGGER.info("Initializing mock data");
        clients.add(new Client(
                "23445322",
                TypeDocument.C,
                "Alberto",
                "Andres",
                "Perez",
                "Dario",
                "654987321",
                "Avenida 1",
                "Berlin"
        ));
    }

    public Optional<Client> findByDocumentAndTypeDocument(String documentNumber, TypeDocument documentType) {
        LOGGER.info("Searching client");
        return clients.stream().filter(client ->
                client.getDocumentNumber().equals(documentNumber) &&
                        client.getTypeDocument() == documentType
        ).findFirst();
    }

    public void create(Client client){
        clients.add(client);
    }
}
