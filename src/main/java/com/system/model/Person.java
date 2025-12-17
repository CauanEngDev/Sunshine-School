package com.system.model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Person implements Identifiable {
    protected final UUID id;
    protected String name;
    protected LocalDate dateOfBirth;
    protected Address address;

    public Person(UUID id, String name, LocalDate dateOfBirth, Address address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public UUID getId() { return id; }

    @Override
    public boolean equals(Identifiable obj) {
        if (this.id == obj.getId()) return true;
    }

    public String getName() { return name; }

    public Address getAddress() { return address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setName(String name) { this.name = name; }

    public void setAddress(Address address) { this.address = address; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
