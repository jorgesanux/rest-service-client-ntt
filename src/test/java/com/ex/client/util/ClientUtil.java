package com.ex.client.util;

import com.ex.client.model.Client;
import com.ex.client.model.TypeDocument;

import java.util.Random;

public class ClientUtil {

    private static Random random = new Random();

    private static String generateRandomDocument(){
        return String.valueOf(Math.abs(random.nextLong())).substring(1,10);
    }
    public static Client generateClient(){
        return new Client(
                generateRandomDocument(),
                TypeDocument.P,
                "Juan",
                "Alberto",
                "Perez",
                "Garcia",
                "123456789",
                "Carrera 1 # 1-1",
                "Cali"
        );
    }
}
