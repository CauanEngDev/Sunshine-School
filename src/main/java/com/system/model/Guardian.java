package com.system.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Guardian extends Person implements IResponsible {
    private String phoneNumber;
    private Set<Student> dependents = new HashSet();

    public Guardian(UUID id, String name, LocalDate dateOfBirth, Address address, String phoneNumber) {
        super(id, name, dateOfBirth, address);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public Set<Student> getDependents() { return new HashSet<>(dependents); }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void addDependent(Student student) { dependents.add(student); }

    public void removeDependent(Student student) { dependents.remove(student); }
}
