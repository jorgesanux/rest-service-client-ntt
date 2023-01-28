package com.ex.client.repository;

import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;
import com.ex.client.util.ClientUtil;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void addClientWithoutErrors(){
        Client client = ClientUtil.generateClient();
        assertDoesNotThrow(() -> this.clientRepository.create(client));
    }

    @Test
    public void addAClientAndVerifyThatItExists(){
        Client client = ClientUtil.generateClient();
        this.clientRepository.create(client);
        Optional<Client> clientFound = this.clientRepository.findByDocumentAndTypeDocument(
            client.getDocumentNumber(),
            client.getTypeDocument()
        );
        assertAll(
            () -> assertTrue(clientFound.isPresent()),
            () -> assertNotNull(clientFound.get())
        );
    }

    @Test
    public void searchAClientThatNotExists(){
        Optional<Client> clientFound = this.clientRepository.findByDocumentAndTypeDocument(
            "147852369",
            TypeDocument.P
        );
        assertFalse(clientFound.isPresent());
    }
}
