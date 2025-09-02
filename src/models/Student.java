package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final String birthPlace;
    private Person responsible;
//    private final List<ReportCard> reportCards;

    public Student(String name, LocalDate dateOfBirth,
                   Address address, int id,
                   String birthPlace, Person responsible) {

        super(id, name, dateOfBirth, address);

        this.birthPlace = birthPlace;
        this.responsible = responsible;
//        this.reportCards = new ArrayList<>();
    }

//    public void addReportCard(ReportCard card) {
//        if (card != null) {
//            this.reportCards.add(card);
//        }
//    }

    public Person getGuardian() {
        return responsible;
    }

    public void setGuardian(Person responsible) {
        this.responsible = responsible;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

//    public List<ReportCard> getReportCards() {
//        return new ArrayList<>(reportCards);
//    }

    @Override
    public String toString() {
        return "Student {" +
                "id = " + id +
                ", name = " + name +
                ", birthPlace = " + birthPlace +
                ", dateOfBirth = " + dateOfBirth +
                '}';
    }
}
