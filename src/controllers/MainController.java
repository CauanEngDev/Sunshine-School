package controllers;

import views.screens.MainFrame;
import views.screens.WelcomeScreen;
import models.panels.LoadingPanel;

import javax.swing.*;
import java.awt.*;


public class MainController {
    private final MainFrame screensPanel;
    private final WelcomeScreen welcomeScreen;

    public MainController(MainFrame screensPanel, WelcomeScreen welcomeScreen) {
        this.screensPanel = screensPanel;
        this.welcomeScreen = welcomeScreen;

        this.welcomeScreen.addStartButtonListener(e -> startLoadingProcess());
    }

    private void startLoadingProcess() {
        LoadingPanel loadingPanel = new LoadingPanel();

        welcomeScreen.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        welcomeScreen.add(loadingPanel, gbc);

        welcomeScreen.revalidate();
        welcomeScreen.repaint();

        Timer timer = new Timer(2500, e -> {
            screensPanel.navigateTo("Choice_Screen");
        });

        timer.setRepeats(false);
        timer.start();
    }
}
