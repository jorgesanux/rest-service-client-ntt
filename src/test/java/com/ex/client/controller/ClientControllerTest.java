package com.ex.client.controller;

import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;
import com.ex.client.repository.ClientRepository;
import com.ex.client.util.ApiError;
import com.ex.client.util.ApiResponse;
import com.ex.client.util.ClientUtil;
import com.ex.client.util.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientControllerTest {
    @Autowired
    private ClientController clientController;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void getSuccessResponseOnQueryClient(){
        Client client = ClientUtil.generateClient();
        this.clientRepository.create(client);

        ResponseEntity<Response> response = this.clientController.getClient(
            client.getDocumentNumber(), client.getTypeDocument()
        );

        ApiResponse body = (ApiResponse) response.getBody();
        Client resultClient = (Client) body.getResult();

        assertAll(
            () -> assertEquals(response.getStatusCode().value(), HttpStatus.OK.value()),
            () -> assertEquals(body.getStatucCode(), HttpStatus.OK.value()),
            () -> assertEquals(body.getMessage(), HttpStatus.OK.getReasonPhrase()),
            () -> assertEquals(resultClient.getDocumentNumber(), client.getDocumentNumber()),
            () -> assertEquals(resultClient.getTypeDocument(), resultClient.getTypeDocument())
        );
    }

    @Test
    public void getNotFoundResponseOnQueryClient(){
        ResponseEntity<Response> response = this.clientController.getClient(
            "159357486", TypeDocument.P
        );

        ApiError body = (ApiError) response.getBody();

        assertAll(
            () -> assertEquals(response.getStatusCode().value(), HttpStatus.NOT_FOUND.value()),
            () -> assertEquals(body.getStatucCode(), HttpStatus.NOT_FOUND.value()),
            () -> assertEquals(body.getError(), HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }
}
