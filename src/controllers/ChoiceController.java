package controllers;

import views.ChoiceScreen;
import javax.swing.*;
import java.awt.*;


public class ChoiceController {
    private final ChoiceScreen choiceScreen;

    public ChoiceController(ChoiceScreen choiceScreen) {
        this.choiceScreen = choiceScreen;

        this.choiceScreen.addClassButtonListener(e -> classOption());
        this.choiceScreen.addGuardianButtonListener(e -> guardianOption());
        this.choiceScreen.addTeacherButtonListener(e -> teacherOption());
        this.choiceScreen.addStudentButtonListener(e -> studentOption());
    }

    private void classOption() {
    }

    private void guardianOption() {
    }

    private void teacherOption() {
    }

    private void studentOption() {
    }
}
