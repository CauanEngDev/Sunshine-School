package com.cauandev.model;

import com.cauandev.enums.Qualifications;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Teacher extends Person implements IResponsible {
    private Qualifications qualification;
    private String phoneNumber;
    private final Set<Student> dependents = new HashSet<>();

    public Teacher(UUID id, String name, LocalDate dateOfBirth,
                   Qualifications qualification, Address address,  String phoneNumber) {
        super(id, name, dateOfBirth, address);
        this.qualification = qualification;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public Set<Student> getDependents() { return new HashSet<>(dependents); }

    public Qualifications getQualification() { return qualification; }

    public void setPhoneNumber(String newPhoneNumber) {
        if (Objects.equals(newPhoneNumber, this.phoneNumber)) return;

        this.phoneNumber = newPhoneNumber;
        this.change = true;
        logger.info("Telefone alterado para {}", newPhoneNumber);
    }

    public void setQualification(Qualifications newQualification) {
        if (Objects.equals(newQualification, this.qualification)) return;

        this.qualification = newQualification;
        this.change = true;
        logger.info("Qualificação alterada para {}", newQualification);
    }

    public void addDependent(Student student) { dependents.add(student); }

    public void removeDependent(Student student) { dependents.remove(student); }
}
