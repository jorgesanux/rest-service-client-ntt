package com.ex.client.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {
    @Test
    public void createClientWithAllParametersConstructor(){
        Client client = new Client(
                "123456798",
                TypeDocument.P,
                "Juan",
                "Alberto",
                "Perez",
                "Garcia",
                "123456789",
                "Carrera 1 # 1-1",
                "Cali"
        );

        assertAll(
            () -> assertEquals(client.getFirstName(), "Juan"),
            () -> assertEquals(client.getSecondName(), "Alberto"),
            () -> assertEquals(client.getFirstLastName(), "Perez"),
            () -> assertEquals(client.getSecondLastName(), "Garcia"),
            () -> assertEquals(client.getCity(), "Cali"),
            () -> assertEquals(client.getAddress(), "Carrera 1 # 1-1"),
            () -> assertEquals(client.getDocumentNumber(), "123456798"),
            () -> assertEquals(client.getTypeDocument(), TypeDocument.P),
            () -> assertEquals(client.getPhoneNumber(), "123456789")
        );
    }

    @Test
    public void generateExceptionOnCreateClientWithNullRequiredProperties(){
        assertThrows(
            NullPointerException.class,
            () -> new Client(null, null)
        );
    }

    @Test
    public void generateExceptionOnCreateClientWithNullTypeDocument(){
        assertThrows(
            NullPointerException.class,
            () -> new Client("123465789", null)
        );
    }

    @Test
    public void generateExceptionOnCreateClientWithNullDocumentNumber(){
        assertThrows(
            NullPointerException.class,
            () -> new Client(null, TypeDocument.P)
        );
    }
}
