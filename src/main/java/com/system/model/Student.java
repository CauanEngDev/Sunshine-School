package com.system.model;

import java.time.LocalDate;
import java.util.UUID;

public class Student extends Person {
    private String birthPlace;
    private Person<? extends Person> responsible;

    public Student (UUID id, String name, LocalDate dateOfBirth, Address address, Person responsible, String birthPlace) {
        super(id, name, dateOfBirth, address);
        this.birthPlace = birthPlace;
        this.responsible = responsible;
    }
}
