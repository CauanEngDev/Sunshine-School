package controllers;

import views.WelcomeScreen;
import views.LoadingPanel;
import views.MainApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainController {
    private WelcomeScreen welcomeScreen;

    public MainController(WelcomeScreen welcomeScreen) {
        this.welcomeScreen = welcomeScreen;

        this.welcomeScreen.addStartButtonListener(e -> startLoadingProcess());
    }

    private void startLoadingProcess() {
        LoadingPanel loadingPanel = new LoadingPanel();

        welcomeScreen.getContentPane().removeAll();
        welcomeScreen.getContentPane().add(loadingPanel);

        welcomeScreen.revalidate();
        welcomeScreen.repaint();

        Timer timer = new Timer(2500, e -> switchToMainApplication());

        timer.setRepeats(false);
        timer.start();
    }

    private void switchToMainApplication() {
        welcomeScreen.dispose();

        MainApplicationFrame mainFrame = new MainApplicationFrame();
        mainFrame.setVisible(true);
    }
}
