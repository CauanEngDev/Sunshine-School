package views.screens;

import models.Student;
import models.panels.BaseViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class StudentDetailsScreen extends BaseViewPanel {
    private JLabel birthPlaceValueLabel;
    private JLabel responsibleValueLabel;

    public StudentDetailsScreen(Student student) {
        super();

        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/resources/Emoji_Aluno.png"));
        Image resizedAvatar = avatarIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        this.avatarLabel.setIcon(new ImageIcon(resizedAvatar));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.nameValueLabel.setText(student.getName());
        this.dateOfBirthValueLabel.setText(student.getDateOfBirth().format(formatter));
        this.birthPlaceValueLabel.setText(student.getBirthPlace());
        this.responsibleValueLabel.setText(student.getGuardian() != null ? student.getGuardian().getName() : "N/A");

        if (student.getAddress() != null) {
            this.streetValueLabel.setText(student.getAddress().street());
            this.neighborhoodValueLabel.setText(student.getAddress().neighborhood());
            this.cepValueLabel.setText(student.getAddress().cep());
            this.cityValueLabel.setText(student.getAddress().city());
            this.stateValueLabel.setText(student.getAddress().state());
        }
    }

    @Override
    protected JPanel createUniqueFieldsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("Naturalidade ->"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        birthPlaceValueLabel = new JLabel();
        panel.add(birthPlaceValueLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panel.add(new JLabel("Responsável ->"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        responsibleValueLabel = new JLabel();
        panel.add(responsibleValueLabel, gbc);

        return panel;
    }

    public void addBackButtonListener(ActionListener listener) {
        this.backButton.addActionListener(listener);
    }
}