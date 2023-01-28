package com.ex.client.service;

import com.ex.client.exception.ClientNotFoundException;
import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;
import com.ex.client.repository.ClientRepository;
import com.ex.client.util.ClientUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;
    @Test
    public void addAClientAndVerifyThatItIsEqual(){
        Client client = ClientUtil.generateClient();
        this.clientRepository.create(client);
        Client clientFound = this.clientService.findByDocumentAndTypeDocument(
            client.getDocumentNumber(),
            client.getTypeDocument()
        );
        assertEquals(clientFound, client);
    }

    @Test
    public void verifyThatThrowsExceptionWhenClientNotExists(){
        assertThrows(
            ClientNotFoundException.class,
            () -> this.clientService.findByDocumentAndTypeDocument(
                "369852147",
                TypeDocument.P
            )
        );
    }
}
