package controllers;

import views.screens.MainFrame;
import views.screens.ChoiceScreen;


public class ChoiceController {
    private final MainFrame screensPanel;
    private final ChoiceScreen choiceScreen;

    public ChoiceController(MainFrame screensPanel, ChoiceScreen choiceScreen) {
        this.screensPanel = screensPanel;
        this.choiceScreen = choiceScreen;

        this.choiceScreen.addClassButtonListener(e -> {
            screensPanel.navigateTo("Class_Option_Screen");
        });
        this.choiceScreen.addGuardianButtonListener(e -> {
            screensPanel.navigateTo("Guardian_Option_Screen");
        });
        this.choiceScreen.addTeacherButtonListener(e -> {
            screensPanel.navigateTo("Teacher_Option_Screen");
        });
        this.choiceScreen.addStudentButtonListener(e -> {
            screensPanel.navigateTo("Student_Option_Screen");
        });
    }
}
