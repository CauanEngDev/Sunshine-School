package views.screens;

import controllers.*;
import views.screens.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel screensPanel;

    public MainFrame() {
        setTitle("Sunshine School Management System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        screensPanel = new JPanel(cardLayout);

        WelcomeScreen welcomeScreen = new WelcomeScreen();
        ChoiceScreen choiceScreen = new ChoiceScreen();
        StudentOptionScreen studentOptionScreen = new StudentOptionScreen();
        ClassOptionScreen classOptionScreen = new ClassOptionScreen();
        GuardianOptionScreen guardianOptionScreen = new GuardianOptionScreen();
        TeacherOptionScreen teacherOptionScreen = new TeacherOptionScreen();

        screensPanel.add(welcomeScreen, "Welcome_Screen");
        screensPanel.add(choiceScreen, "Choice_Screen");
        screensPanel.add(studentOptionScreen, "Student_Option_Screen");
        screensPanel.add(classOptionScreen, "Class_Option_Screen");
        screensPanel.add(guardianOptionScreen, "Guardian_Option_Screen");
        screensPanel.add(teacherOptionScreen, "Teacher_Option_Screen");

        new MainController(this, welcomeScreen);
        new ChoiceController(this, choiceScreen);
        new StudentOptionController(this, studentOptionScreen);

        add(screensPanel);
    }

    public void navigateTo(String screenName) {
        cardLayout.show(screensPanel, screenName);
        System.out.println("Navegando para a tela: "  + screenName);
    }

    public void addScreen(JPanel screen, String screenName) {
        screensPanel.add(screen, screenName);
    }
}
