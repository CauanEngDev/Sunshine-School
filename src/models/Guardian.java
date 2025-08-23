package models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Guardian extends Person{
    private String phone;
    private List<Student>  dependents;

    public Guardian(String name, LocalDate dateOfBirth,
                    Address address, String phone,
                    List<Student> dependents) {

        super(name, dateOfBirth, address);

        this.phone = phone;
        
        if (dependents != null) {
            this.dependents = new ArrayList<>(dependents);
        } else {
            this.dependents = new ArrayList<>();
        }
    }
}