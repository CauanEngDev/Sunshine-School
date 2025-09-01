package controllers;

import views.screens.ClassOptionScreen;
import views.screens.MainFrame;

public class ClassOptionController {
    private final MainFrame screensPanel;
    private final ClassOptionScreen view;

    public ClassOptionController(MainFrame screensPanel, ClassOptionScreen view) {
        this.screensPanel = screensPanel;
        this.view = view;

        this.view.addBackButtonListener(e -> {
            screensPanel.navigateTo("Choice_Screen");
        });
//        this.view.addCreateButtonListener(e -> goToCreateStudent());
//        this.view.addEditButtonListener(e-> goToEditStudent());
//        this.view.addRemoveButtonListener(e -> goToRemoveStudent());
//        this.view.addSearchButtonListener(e -> goToSearchStudent());
    }
}
