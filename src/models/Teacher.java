package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private String qualification;
    private String phone;
    private List<Student> dependents;

    public  Teacher(String name, LocalDate dateOfBirth, Address address,
                    String qualification, String phone, List<Student> dependents) {

        super(name, dateOfBirth, address);

        this.qualification = qualification;
        this.phone = phone;
        if (dependents != null) {
            this.dependents = new ArrayList<>(dependents);
        } else {
            this.dependents = new ArrayList<>();
        }
    }
}




