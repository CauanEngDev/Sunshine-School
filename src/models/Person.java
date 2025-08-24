package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected final int id;
    protected String name;
    protected LocalDate dateOfBirth;
    protected Address address;

    protected Person(int id, String name, LocalDate dateOfBirth, Address address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    // --- MÉTODOS DE MODIFICAÇÃO (SETTERS) DA CLASSE MÃE ---
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address newAddress) {
        this.address = newAddress;
    }

    // --- MÉTODOS DE ACESSO (GETTERS) DA CLASSE MÃE ---

    public String getName(){
        return this.name;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public Address getAddress(){
        return this.address;
    }

    public int getId() {
        return id;
    }
}