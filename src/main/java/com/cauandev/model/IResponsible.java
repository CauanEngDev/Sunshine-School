package com.cauandev.model;

import java.util.Set;

public interface IResponsible {
    Set<Student> getDependents();
    void addDependent(Student student);
    void removeDependent(Student student);
}
