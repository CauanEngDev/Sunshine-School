package models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Guardian extends Person{
    private String phone;
    private  final List<Student>  dependents;

    public Guardian(String name, LocalDate dateOfBirth,
                    Address address, int id, String phone,
                    List<Student> dependents) {

        super(id, name, dateOfBirth, address);

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

    public String getPhone() {
        return phone;
    }

    public List<Student> getDependents() {
        return new ArrayList<>(dependents);
    }

    // Função que retorna todas as informações importantes de Guardian
    @Override
    public String toString() {
        return "Guardian {" +
                "id = " + id +
                ", name = " + name +
                ", phone = " + phone +
                ", dateOfBirth = " + dateOfBirth +
                ", dependents count = " + dependents.size() +
                '}';

    }
}