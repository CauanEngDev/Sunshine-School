package models;

import java.time.LocalDate;

public abstract class Person {
    protected String name;
    protected LocalDate dateOfBirth;
    protected Address address;

    protected Person(String name, LocalDate dateOfBirth, Address address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }
}