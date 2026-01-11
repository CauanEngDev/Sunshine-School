package com.cauandev.model;

/**
 * Classe 'record' que cria o endereço dos usuários
 * @param street rua do usuário
 * @param city cidade do usuário
 * @param state estado do usuário
 * @param cep cep do usuário
 * @param neighborhood bairro do usuário
 */
public record Address(String street, String city, String state, String cep, String neighborhood) {}
