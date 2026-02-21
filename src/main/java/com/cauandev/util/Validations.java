package com.cauandev.util;

import com.cauandev.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe de validações para checagem geral de informações pessoais.
 */
public class Validations {
    // Log para mensagens de erro.
    private static final Logger log = LoggerFactory.getLogger(Validations.class);

    /**
     * Método que verifica se parâmetros tipo 'String' são vazios ou nulls e lança logs + exceções para
     * correção de erros.
     * @param obj Lista de parâmetros que serão verificados.
     */
    public static void textValidation(String... obj) {
        for (int i = 0; i < obj.length; i+=2) {
            if (obj[i] == null || obj[i].isBlank()) {
                log.error("Erro de validação: {} está em branco!", obj[i+1]);
                throw new ValidationException("Campo " + obj[i+1] + " precisa estar preenchido!");
            }
        }
    }

    /**
     * Método para checagem de número de telefone.
     * @param phoneNumber variável telefone.
     */
    public static void phoneValidation(String phoneNumber) {
        // Verifica se telefone é vazio ou null e lança um 'log' + exceção para tratamento de erro.
        if (phoneNumber == null || phoneNumber.isBlank()) {
            log.error("Campo número de telefone precisar estar preenchido!");
            throw new ValidationException("Campo telefone precisa estar preenchido!");
        }

        // Verifica se o número está no formato correto.
        else if (phoneNumber.length() != 11 || !(phoneNumber.matches("[0-9]+"))) {
            log.error("O número de telefone precisa conter apenas número e estar no formato 00123456789!");
            throw new ValidationException("Formato do telefone incorreto!");
        }
    }
}
