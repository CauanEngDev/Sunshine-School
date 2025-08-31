package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import utils.RoundedButton;

public class ChoiceScreen extends JFrame {
    private RoundedButton studentButton;
    private RoundedButton guardianButton;
    private RoundedButton teacherButton;
    private RoundedButton classButton;

    public ChoiceScreen() {
        setTitle("Tela de Escolha");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImagePanel backgroundPanel = new ImagePanel("/resources/Tela de Escolha.png");
        backgroundPanel.setLayout(new GridBagLayout());
        setContentPane(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 0, 20, 0);

        JLabel choiceLabel = new JLabel("Escolha uma das opções");
        choiceLabel.setFont(new Font("Magic School One", Font.BOLD, 30));
        choiceLabel.setForeground(Color.decode("#87CEFA"));
        backgroundPanel.add(choiceLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setOpaque(false);

        studentButton = new RoundedButton("Aluno", 30);
        guardianButton = new RoundedButton("Responsável", 30);
        teacherButton = new RoundedButton("Professor", 30);
        classButton = new RoundedButton("Turma", 30);

        buttonPanel.add(studentButton);
        buttonPanel.add(guardianButton);
        buttonPanel.add(teacherButton);
        buttonPanel.add(classButton);

        backgroundPanel.add(buttonPanel, gbc);
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
