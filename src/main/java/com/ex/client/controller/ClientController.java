package com.ex.client.controller;

import com.ex.client.exception.ClientNotFoundException;
import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;
import com.ex.client.service.ClientService;
import com.ex.client.util.ApiError;
import com.ex.client.util.ApiResponse;
import com.ex.client.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Response> getClient(
            @RequestParam(name = "doc_number") String documentNumber,
            @RequestParam(name = "doc_type") TypeDocument documentType
    ) {
        ResponseEntity responseEntity;
        try {
            //200
            Client client = this.clientService.
                    findByDocumentAndTypeDocument(documentNumber, documentType);
            responseEntity = new ResponseEntity<>(new ApiResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    client
            ), HttpStatus.OK);
        } catch (ClientNotFoundException error) {
            //404
            responseEntity = new ResponseEntity<>(new ApiError(
                    HttpStatus.NOT_FOUND,
                    error.getMessage()
            ), HttpStatus.NOT_FOUND);
            LOGGER.warn(error.getMessage());
        } catch (Exception error) {
            //500
            responseEntity = new ResponseEntity<>(new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    error.getMessage()
            ), HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.getMessage(), error);
        }
        return responseEntity;
    }
}
