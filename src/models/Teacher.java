package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private String qualification;
    private String phone;
    private final List<Student> dependents;

    public  Teacher(String name, LocalDate dateOfBirth, Address address,
                    int id, String qualification, String phone) {

        super(id, name, dateOfBirth, address);

        this.qualification = qualification;
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

    public String getQualification() {
        return qualification;
    }

    public String getPhone() {
        return phone;
    }

    public List<Student> getDependents() {
        return new ArrayList<>(dependents);
    }

    public String getName() {
        return this.name + " (Professor)";
    }

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