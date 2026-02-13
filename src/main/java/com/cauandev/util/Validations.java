package com.cauandev.util;

import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validations {
    private static final Logger log = LoggerFactory.getLogger(Validations.class);

    public static void textValidation(String... obj) {
        for (int i = 0; i < obj.length; i+=2) {
            if (obj[i] == null || obj[i].isEmpty()) {
                // Checa se o campo é nulo ou vazio e mostra uma msg de erro
                log.error("Campo {} precisar estar preenchido", obj[i+1]);
                // Caso der erro, fecha o front e back
                Platform.exit();
            }
        }
    }

    public static void phoneValidation(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            log.error("Campo número de telefone precisar estar preenchido!");
            Platform.exit();
        }
        
        else if (phoneNumber.length() != 11 || !(phoneNumber.matches("[0-9]+"))) {
            log.error("O número de telefone precisa conter apenas número e estar no formato (xx)xxxxxxxxx!");
            Platform.exit();
        }
    }
}
