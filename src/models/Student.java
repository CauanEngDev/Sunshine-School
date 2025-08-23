package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private int id;
    private String birthPlace;
    private List<ReportCard> reportCards;

    public Student(String name, LocalDate dateOfBirth,
                   Address address, int id,
                   String birthPlace) {

        super(name, dateOfBirth, address);

        this.id = id;
        this.birthPlace = birthPlace;
        this.reportCards = new ArrayList<>();
    }
}
