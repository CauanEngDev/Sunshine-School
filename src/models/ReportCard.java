package models;

import java.util.List;
import java.util.ArrayList;

public class ReportCard {
    private List<Score> grades;

    public ReportCard(List<Score> grades) {
        // If...Else para evitar que exista uma lista nula
        if (grades != null) {
            this.grades = new ArrayList<>(grades);
        } else {
            this.grades = new ArrayList<>();
        }
    }
}
