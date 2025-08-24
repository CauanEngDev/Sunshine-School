package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private String qualification;
    private String phone;
    private final List<Student> dependents;

    public  Teacher(String name, LocalDate dateOfBirth, Address address,
                    int id, String qualification, String phone, List<Student> dependents) {

        super(id, name, dateOfBirth, address);

        this.qualification = qualification;
        this.phone = phone;
        if (dependents != null) {
            this.dependents = new ArrayList<>(dependents);
        } else {
            this.dependents = new ArrayList<>();
        }
    }

    // --- MÉTODOS DE MODIFICAÇÃO (SETTERS) ---

    public void addDependent(Student dependent) {
        if (dependent != null) {
            this.dependents.add(dependent);
        }
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }

    // --- MÉTODOS DE ACESSO (GETTERS) ---

    public String getQualification() {
        return qualification;
    }

    public String getPhone() {
        return phone;
    }

    public List<Student> getDependents() {
        return new ArrayList<>(dependents);
    }

    // Função que retorna todas informções importantes de Teacher ao mesmo tempo
    @Override
    public String toString() {
        return "Teacher {" +
                "id = " + id +
                ", name = " + name +
                ", phone = " + phone +
                ", dateOfBirth = " + dateOfBirth +
                ", qualification = " + qualification +
                ", dependents count = " + dependents.size() +
                '}';

    }
}