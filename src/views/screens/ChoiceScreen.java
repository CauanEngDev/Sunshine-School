package views.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import utils.RoundedButton;
import models.panels.ImagePanel;

public class ChoiceScreen extends ImagePanel {
    private final RoundedButton studentButton;
    private final RoundedButton guardianButton;
    private final RoundedButton teacherButton;
    private final RoundedButton classButton;

    public ChoiceScreen() {
        super("/resources/Tela de Escolha.png");

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;

        JPanel pusherPanel = new JPanel();
        pusherPanel.setOpaque(false);

        gbc.gridy = 0;
        gbc.weighty = 1.2;

        this.add(pusherPanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(0, 0, 10, 0);

        RoundedButton labelBox = new RoundedButton("    Escolha uma da opções    ", 40);
        this.add(labelBox, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setOpaque(false);

        studentButton = new RoundedButton("   Aluno   ", 30);
        guardianButton = new RoundedButton("   Responsável   ", 30);
        teacherButton = new RoundedButton("   Professor   ", 30);
        classButton = new RoundedButton("   Turma   ", 30);

        buttonPanel.add(studentButton);
        buttonPanel.add(guardianButton);
        buttonPanel.add(teacherButton);
        buttonPanel.add(classButton);

        gbc.gridy = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 0, 0, 0);

        this.add(buttonPanel, gbc);

        JPanel pusherPanel2 = new JPanel();
        pusherPanel2.setOpaque(false);
        gbc.gridy = 3;
        gbc.weighty = 0.4;
        this.add(pusherPanel2, gbc);
    }

    public void addStudentButtonListener(ActionListener listener) {
        studentButton.addActionListener(listener);
    }

    public void addTeacherButtonListener(ActionListener listener) {
        teacherButton.addActionListener(listener);
    }

    public void addClassButtonListener(ActionListener listener) {
        classButton.addActionListener(listener);
    }

    public void addGuardianButtonListener(ActionListener listener) {
        guardianButton.addActionListener(listener);
    }
}
