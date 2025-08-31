package controllers;

import views.WelcomeScreen;
import views.LoadingPanel;
import views.ChoiceScreen;

import javax.swing.*;
import java.awt.*;


public class MainController {
    private final WelcomeScreen welcomeScreen;

    public MainController(WelcomeScreen welcomeScreen) {
        this.welcomeScreen = welcomeScreen;

        this.welcomeScreen.addStartButtonListener(e -> startLoadingProcess());
    }

    private void startLoadingProcess() {
        LoadingPanel loadingPanel = new LoadingPanel();

        welcomeScreen.getContentPane().removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        welcomeScreen.getContentPane().add(loadingPanel, gbc);

        welcomeScreen.revalidate();
        welcomeScreen.repaint();

        Timer timer = new Timer(2500, e -> switchToChoiceScreen());

        timer.setRepeats(false);
        timer.start();
    }

    private void switchToChoiceScreen() {
        welcomeScreen.dispose();

        ChoiceController choiceScreen = new ChoiceController();
        choiceScreen.setVisible(true);
    }
}
