package controllers;

import data.SchoolDatabase;
import models.Guardian;
import models.Person;
import models.Teacher;
import views.screens.MainFrame;
import views.screens.CreateTeacherScreen;
import views.screens.ListTeachersScreen;
import views.screens.TeacherOptionScreen;

import java.util.ArrayList;
import java.util.List;

public class TeacherOptionController {
    private final MainFrame mainFrame;
    private final TeacherOptionScreen view;

    public TeacherOptionController(MainFrame mainFrame, TeacherOptionScreen view) {
        this.mainFrame = mainFrame;
        this.view = view;

        this.view.addBackButtonListener(e -> mainFrame.navigateTo("Choice_Screen"));
        this.view.addCreateButtonListener(e -> openCreateTeacherForm());
        this.view.addRemoveButtonListener(e -> openRemoveTeacherScreen());
    }

    private void openCreateTeacherForm() {
        CreateTeacherScreen createScreen = new CreateTeacherScreen();
        new TeacherFormController(createScreen, mainFrame);

        String screenName = "Create_Teacher_Screen";
        mainFrame.addScreen(createScreen, screenName);
        mainFrame.navigateTo(screenName);
    }

    private void openRemoveTeacherScreen() {
        ListTeachersScreen listScreen = new ListTeachersScreen();
        new ListTeachersController(mainFrame, listScreen);

        String screenName = "List_Teacher_Screen";
        mainFrame.addScreen(listScreen, screenName);
        mainFrame.navigateTo(screenName);
    }
}