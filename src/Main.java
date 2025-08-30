import views.WelcomeScreen;
import controllers.MainController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            new MainController(welcomeScreen);
        });
    }
}