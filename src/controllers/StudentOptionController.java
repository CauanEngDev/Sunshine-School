package controllers;

import data.SchoolDatabase;
import models.Person;
import models.Teacher;
import views.screens.CreateStudentScreen;
import views.screens.ListStudentScreen;
import views.screens.MainFrame;
import views.screens.StudentOptionScreen;
import models.Guardian;

import java.util.List;
import java.util.ArrayList;

public class StudentOptionController {
    private final MainFrame screensPanel;
    private final StudentOptionScreen view;

    public StudentOptionController(MainFrame screensPanel, StudentOptionScreen view) {
        this.screensPanel = screensPanel;
        this. view = view;

        this.view.addBackButtonListener(e -> {
            screensPanel.navigateTo("Choice_Screen");
        });
        this.view.addCreateButtonListener(e -> openCreateStudentForm());
//        this.view.addEditButtonListener(e-> goToEditStudent());
        this.view.addRemoveButtonListener(e -> goToRemoveStudent());
//        this.view.addSearchButtonListener(e -> goToSearchStudent());
    }

    private void openCreateStudentForm() {
        List<Guardian> guardianList = SchoolDatabase.guardians;
        List<Teacher>  teacherList = SchoolDatabase.teachers;

        List<Person> resposibleList = new ArrayList<>();
        resposibleList.addAll(guardianList);
        resposibleList.addAll(teacherList);

        CreateStudentScreen createStudentScreen = new CreateStudentScreen(resposibleList);

        new StudentFormController(createStudentScreen, screensPanel);

        screensPanel.addScreen(createStudentScreen, "Create_Student_Screen");
        screensPanel.navigateTo("Create_Student_Screen");
    }

    private void goToRemoveStudent() {
        ListStudentScreen listStudentScreen = new ListStudentScreen();

        screensPanel.addScreen(listStudentScreen, "List_Student_Screen");
        screensPanel.navigateTo("List_Student_Screen");
    }
}