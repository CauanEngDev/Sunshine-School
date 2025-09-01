package views.screens;

import models.Guardian;
import models.Person;
import models.panels.BaseFormPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CreateStudentScreen extends BaseFormPanel {
    private JTextField birthPlace;
    private JComboBox<Person> guardianComboBox;

    public CreateStudentScreen(List<Person> responsibleList) {
        super();

        guardianComboBox.setModel(new DefaultComboBoxModel<>(responsibleList.toArray(new Person[0])));
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
        panel.add(new JLabel("Birth Place:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField birthPlaceField = new JTextField(20);
        panel.add(birthPlaceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(new Label("Responsável:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        guardianComboBox = new JComboBox<>();
        panel.add(guardianComboBox, gbc);

        return panel;
    }

    public String getBirth() {
        return birthPlace.getText();
    }

    public Guardian getSelectedGuardian() {
        return (Guardian) guardianComboBox.getSelectedItem();
    }

    public void addSaveButtonListener(ActionListener actionListener) {
        this.saveButton.addActionListener(actionListener);
    }

    public void addCancelButtonListener(ActionListener actionListener) {
        this.cancelButton.addActionListener(actionListener);
    }
}
