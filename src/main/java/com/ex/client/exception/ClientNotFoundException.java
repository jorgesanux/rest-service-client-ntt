package com.ex.client.exception;

import com.ex.client.model.TypeDocument;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String documentNumber, TypeDocument documentType) {
        super(String.format("Client %s with document type %s not found", documentNumber, documentType));
    }
}
