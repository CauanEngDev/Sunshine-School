package controllers;

import data.SchoolDatabase;
import models.Person;
import views.screens.MainFrame;
import views.screens.CreateGuardianScreen;
import views.screens.GuardianOptionScreen;
import views.screens.ListGuardiansScreen;

import java.util.ArrayList;
import java.util.List;

public class GuardianOptionController {
    private final MainFrame mainFrame;
    private final GuardianOptionScreen view;

    public GuardianOptionController(MainFrame mainFrame, GuardianOptionScreen view) {
        this.mainFrame = mainFrame;
        this.view = view;

        this.view.addBackButtonListener(e -> mainFrame.navigateTo("Choice_Screen"));
        this.view.addCreateButtonListener(e -> openCreateGuardianForm());
        this.view.addRemoveButtonListener(e -> openRemoveGuardianScreen());
    }

    private void openCreateGuardianForm() {
        CreateGuardianScreen createScreen = new CreateGuardianScreen();
        new GuardianFormController(createScreen, mainFrame);

        String screenName = "Create_Guardian_Screen";
        mainFrame.addScreen(createScreen, screenName);
        mainFrame.navigateTo(screenName);
    }

    private void openRemoveGuardianScreen() {
        ListGuardiansScreen listScreen = new ListGuardiansScreen();
        new ListGuardiansController(mainFrame, listScreen);

        String screenName = "LIST_GUARDIANS";
        mainFrame.addScreen(listScreen, screenName);
        mainFrame.navigateTo(screenName);
    }
}