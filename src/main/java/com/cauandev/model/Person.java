package com.cauandev.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe abstrata que coleta 'id', nome, data de aniversário e endereço e passa para as
 * classes filhas. Também implementa 'interface' 'Indentifiable'.
 */
public abstract class Person implements Identifiable {
    protected static final Logger logger = LoggerFactory.getLogger(Person.class);
    protected final UUID id;
    protected String name;
    protected LocalDate dateOfBirth;
    protected Address address;
    protected boolean change = false;

    protected Person(UUID id, String name, LocalDate dateOfBirth, Address address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public UUID getId() { return id; }

    // Sobrescrita do 'equals' para comparação de acordo com 'id'
    @Override
    public boolean equals(Identifiable obj) {
        return this.getId().equals(obj.getId());
    }

    public String getName() { return name; }

    public Address getAddress() { return address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setName(String newName) {
        if (Objects.equals(newName, this.name)) return;

        this.name = newName;
        this.change = true;
        logger.info("Nome alterado para {}", newName);
    }

    public void setAddress(Address newAddress) {
        if (Objects.equals(newAddress, this.address)) return;

        this.address = newAddress;
        this.change = true;
        logger.info("Endereço alterado");
    }

    public void setDateOfBirth(LocalDate newDateOfBirth) {
        if (Objects.equals(newDateOfBirth, this.dateOfBirth)) return;

        this.dateOfBirth = newDateOfBirth;
        this.change = true;
        logger.info("Data de aniversário alterada para {}", newDateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public boolean getChange() { return this.change; }

    public void setChange(boolean newChange) { this.change = newChange; }
}
