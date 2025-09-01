package views.screens;

import java.awt.*;
import java.awt.event.ActionListener;
import utils.RoundedButton;
import models.panels.ImagePanel;

public class WelcomeScreen extends ImagePanel {
    private final RoundedButton startButton;

    public WelcomeScreen() {
        super("/resources/WelcomeScreen.png");

        this.setLayout(new GridBagLayout());

        startButton = new RoundedButton("Iniciar", 40);
        startButton.setPreferredSize(new Dimension(180, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0, 0, 50, 0);

        this.add(startButton, gbc);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}