package com.cauandev.service;

import com.cauandev.model.Address;
import com.cauandev.model.Identifiable;
import com.cauandev.util.Validations;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public abstract class PersonService {
    protected UUID newId;
    protected Address address;

    protected void basicInfoValidation(Map<UUID, ? extends Identifiable> map, String name, LocalDate dateOfBirth,
                         String street, String city, String state, String cep, String neighborhood) {

        Validations.textValidation(name, "nome", dateOfBirth == null ? "" : dateOfBirth.toString(), "data de nascimento");
        address = AddressService.createAddress(street, city, state, cep, neighborhood);
        do {
            newId = UUID.randomUUID();
        } while (map.containsKey(newId));
    }
}