package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final String birthPlace;
    private Guardian guardian;
//    private final List<ReportCard> reportCards;

    public Student(String name, LocalDate dateOfBirth,
                   Address address, int id,
                   String birthPlace, Guardian guardian) {

        super(id, name, dateOfBirth, address);

        this.birthPlace = birthPlace;
        this.guardian = guardian;
//        this.reportCards = new ArrayList<>();
    }

//    public void addReportCard(ReportCard card) {
//        if (card != null) {
//            this.reportCards.add(card);
//        }
//    }

    public String getGuardianName() {
        return guardian.getName();
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
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
