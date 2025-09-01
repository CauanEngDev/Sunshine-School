package controllers;

import views.screens.MainFrame;
import views.screens.TeacherOptionScreen;

public class TeacherOptionController {
    private final TeacherOptionScreen view;
    private final MainFrame screensPanel;

    public TeacherOptionController(TeacherOptionScreen view, MainFrame screensPanel) {
        this.view = view;
        this.screensPanel = screensPanel;

        this.view.addBackButtonListener(e -> {
            screensPanel.navigateTo("Choice_Screen");
        });
//        this.view.addCreateButtonListener(e -> goToCreateStudent());
//        this.view.addEditButtonListener(e-> goToEditStudent());
//        this.view.addRemoveButtonListener(e -> goToRemoveStudent());
//        this.view.addSearchButtonListener(e -> goToSearchStudent());
    }
}
