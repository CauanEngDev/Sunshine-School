package models;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private int academicYear;
    private List<Student> students;
    private String gradeLevel;
    private Teacher teacher;

    public SchoolClass(int academicYear, Teacher teacher,
                       String gradeLevel,  List<Student> students) {
        this.academicYear = academicYear;
        this.teacher = teacher;
        this.gradeLevel = gradeLevel;
        if (students != null) {
            this.students = new ArrayList<>(students);
        } else {
            this.students = new ArrayList<>();
        }
    }
}
