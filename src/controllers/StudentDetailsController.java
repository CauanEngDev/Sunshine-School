package controllers;

import views.screens.MainFrame;
import views.screens.StudentDetailsScreen;

public class StudentDetailsController {
    private final StudentDetailsScreen view;
    private final MainFrame screensPanel;

    public StudentDetailsController(MainFrame screensPanel, StudentDetailsScreen view) {
        this.view = view;
        this.screensPanel = screensPanel;

        this.view.addBackButtonListener(e -> screensPanel.navigateTo("List_Student_Screen"));
    }
}