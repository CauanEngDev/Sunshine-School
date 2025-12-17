package com.system.model;

import java.time.LocalDate;
import java.util.UUID;

public class Student extends Person {
    private String birthPlace;
    private IResponsible responsible;

    public Student (UUID id, String name, LocalDate dateOfBirth, Address address, IResponsible responsible, String birthPlace) {
        super(id, name, dateOfBirth, address);
        this.birthPlace = birthPlace;
        this.responsible = responsible;
    }

    public String getBirthPlace() { return birthPlace; }

    public IResponsible getResponsible() { return responsible; }

    public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }

    public void setResponsible(IResponsible responsible) { this.responsible = responsible; }
}
