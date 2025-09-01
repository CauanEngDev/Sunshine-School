package controllers;

import views.screens.GuardianOptionScreen;
import views.screens.MainFrame;

public class GuardianOptionController {
    private final MainFrame screensPanel;
    private final GuardianOptionScreen view;

    public GuardianOptionController(MainFrame screensPanel, GuardianOptionScreen view) {
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
