package models;

// Método record class já cria uma classe que apenas guardar valores imutáveis
// Esta função já implementa todas as funções necessárias para uma classe deste tipo
public record Address(String street, String city,
                      String state, String cep, String neighborhood) {}