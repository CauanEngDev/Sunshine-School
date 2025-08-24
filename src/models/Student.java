package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final String birthPlace;
    private final List<ReportCard> reportCards;

    public Student(String name, LocalDate dateOfBirth,
                   Address address, int id,
                   String birthPlace) {

        super(id, name, dateOfBirth, address);

        this.birthPlace = birthPlace;
        this.reportCards = new ArrayList<>();
    }

    // --- MÉTODOS DE MODIFICAÇÃO (SETTERS) ---

    public void addReportCard(ReportCard card) {
        if (card != null) {
            this.reportCards.add(card);
        }
    }

    // --- MÉTODOS DE ACESSO (GETTERS) ---

    public String getBirthPlace() {
        return birthPlace;
    }

    public List<ReportCard> getReportCards() {
        return new ArrayList<>(reportCards);
    }

    //Função que retorna as informações importantes de Student
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
