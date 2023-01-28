package com.ex.client.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Client {
    @NonNull
    private String documentNumber;
    @NonNull
    private TypeDocument typeDocument;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;


}
