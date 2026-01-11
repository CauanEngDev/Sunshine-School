package com.cauandev.model;

import java.util.HashSet;
import java.util.Set;

public class SchoolClass {
    private int academicYear;
    private Set<Student> students =  new HashSet();
    private GradeLevels gradeLevel;
    private Teacher teacher;

    public SchoolClass(int academicYear, GradeLevels gradeLevel,
                       Teacher teacher) {
        this.academicYear = academicYear;
        this.gradeLevel = gradeLevel;
        this.teacher = teacher;
    }

    public int getAcademicYear() { return academicYear; }

    public Set<Student> getStudents() { return new HashSet<>(students); }

    public GradeLevels getGradeLevel() { return gradeLevel; }

    public Teacher getTeacher() { return teacher; }

    public void setAcademicYear(int academicYear) { this.academicYear = academicYear; }

    public void setGradeLevel(GradeLevels gradeLevel) { this.gradeLevel = gradeLevel; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public void addStudent(Student student) { students.add(student); }

    public void removeStudent(Student student) { students.remove(student); }
}
