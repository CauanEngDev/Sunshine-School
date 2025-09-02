package models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Guardian extends Person{
    private String phone;
    private  final List<Student> dependents;

    public Guardian(String name, LocalDate dateOfBirth,
                    Address address, int id, String phone) {

        super(id, name, dateOfBirth, address);

        this.phone = phone;

        this.dependents = new ArrayList<>();
    }

    public void addDependent(Student dependent) {
        if (dependent != null) {
            this.dependents.add(dependent);
        }
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }

    public String getPhone() {
        return phone;
    }

    public List<Student> getDependents() {
        return new ArrayList<>(dependents);
    }

    public String getName() {
        return this.name;
    }
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