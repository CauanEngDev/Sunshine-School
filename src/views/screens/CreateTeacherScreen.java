package views.screens;

import models.panels.BaseFormPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateTeacherScreen extends BaseFormPanel {
    private JTextField qualificationField;
    private JTextField phoneField;

    public CreateTeacherScreen() {
        super();

        ImageIcon studentIcon = new ImageIcon(getClass().getResource("/resources/Emoji_Professor_Feliz.png"));
        Image resizedImage = studentIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);

        this.avatarLabel.setIcon(new ImageIcon(resizedImage));
    }

    @Override
    protected JPanel createUniqueFields() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Telefone -> "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.phoneField = new JTextField(20);
        panel.add(this.phoneField, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        panel.add(new JLabel("Formação -> "), gbc);

        gbc.gridx = 3;
        gbc.weightx = 1.0;
        this.qualificationField = new JTextField(30);
        panel.add(qualificationField, gbc);

        return panel;
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getQualification() {
        return qualificationField.getText();
    }

    public void addSaveButtonListener(ActionListener actionListener) {
        this.saveButton.addActionListener(actionListener);
    }

    public void addCancelButtonListener(ActionListener actionListener) {
        this.cancelButton.addActionListener(actionListener);
    }
}
