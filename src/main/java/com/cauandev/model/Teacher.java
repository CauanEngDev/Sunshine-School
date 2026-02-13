package com.cauandev.model;

import java.time.LocalDate;
import java.util.HashSet;
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

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setQualification(Qualifications qualification) { this.qualification = qualification; }

    public void addDependent(Student student) { dependents.add(student); }

    public void removeDependent(Student student) { dependents.remove(student); }
}
