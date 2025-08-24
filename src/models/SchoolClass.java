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
        this.academicYear = academicYear; // Ano atual (ex: 2005)
        this.teacher = teacher;
        this.gradeLevel = gradeLevel; // Série da sala (ex: 3° ano do ensino médio)
        if (students != null) {
            this.students = new ArrayList<>(students);
        } else {
            this.students = new ArrayList<>();
        }
    }

    // --- MÉTODOS DE MODIFICAÇÃO (SETTERS) ---

    public void setTeacher(Teacher newTeacher) {
        this.teacher = newTeacher;
    }

    public void setGradeLevel(String newGradeLevel) {
        this.gradeLevel = newGradeLevel;
    }

    public void setAcademicYear(int newAcademicYear) {
        this.academicYear = newAcademicYear;
    }

    public void addStudent(Student newStudent) {
        if (newStudent != null) {
            this.students.add(newStudent);
        }
    }

    public boolean removeStudent(Student oldStudent) {
        // Se o aluno estava na turma, remove-o, caso contrário, retorna false para que o programador saiba
        // que o aluno não estava na turma
        if (oldStudent != null) {
            return this.students.remove(oldStudent);
        }
        return false;
    }

    // --- MÉTODOS DE ACESSO (GETTERS) ---

    public int getAcademicYear() {
        return academicYear;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}