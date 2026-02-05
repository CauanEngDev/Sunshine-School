package com.cauandev.service;

import com.cauandev.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    public Address createAddress(String street, String city, String state, String cep, String neighborhood) {
        if (street == null || city == null || state == null || cep == null || neighborhood == null) {
            logger.info("Todos os campos precisam estar preenchidos!");
            return null;
        }

        return new Address(street, city, state, cep, neighborhood);
    }
}
