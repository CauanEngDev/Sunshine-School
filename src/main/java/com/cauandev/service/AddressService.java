package com.cauandev.service;

import com.cauandev.model.Address;
import com.cauandev.util.Validations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    public static Address createAddress(String street, String city, String state, String cep, String neighborhood) {
        Validations.textValidation(street, "rua", city, "cidade", state, "estado",
                                    cep, "cep", neighborhood, "bairro");

        return new Address(street, city, state, cep, neighborhood);
    }
}
