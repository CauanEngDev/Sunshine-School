package models.panels;

import utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFormPanel extends ImagePanel {
    protected JTextField nameField;
    protected JTextField dateOfBirthField;
    protected JTextField streetField;
    protected JTextField cityField;
    protected JTextField cepField;
    protected JTextField neighborhoodField;
    protected JTextField stateField;
    protected RoundedButton cancelButton;
    protected RoundedButton saveButton;
    protected final JLabel avatarLabel;

    public BaseFormPanel() {
        super("/resources/Tela Padrão 2.png");
        this.setLayout(new GridBagLayout());

        avatarLabel = new JLabel();
        GridBagConstraints gbc_avatar = new GridBagConstraints();
        gbc_avatar.gridx = 0;
        gbc_avatar.gridy = 0;
        gbc_avatar.anchor = GridBagConstraints.NORTHWEST;
        gbc_avatar.insets = new Insets(10, 40, 20, 20);
        this.add(avatarLabel, gbc_avatar);

        JPanel formContainer = new JPanel();
        formContainer.setOpaque(false);
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

        formContainer.add(Box.createRigidArea(new  Dimension(0, 30)));
        formContainer.add(createPersonalInfo());
        formContainer.add(Box.createRigidArea(new  Dimension(0, 10)));
        formContainer.add(createUniqueFields());
        formContainer.add(Box.createRigidArea(new  Dimension(0, 250)));
        formContainer.add(createAddressPanel());

        formContainer.add(Box.createVerticalGlue());

        formContainer.add(createButtonPanel());

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 1;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;
        gbcMain.fill = GridBagConstraints.HORIZONTAL;
        gbcMain.anchor = GridBagConstraints.NORTH;
        gbcMain.insets = new Insets(20, 0, 20, 40);
        this.add(formContainer, gbcMain);
    }

    protected abstract JPanel createUniqueFields();

    private JPanel createAddressPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 0: Rua
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("Rua ->"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 5; gbc.weightx = 1.0;
        streetField = new JTextField();
        panel.add(streetField, gbc);

        // Linha 1: Bairro e CEP
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panel.add(new JLabel("Bairro ->"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        neighborhoodField = new JTextField();
        panel.add(neighborhoodField, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1; gbc.weightx = 0; gbc.insets = new Insets(4, 20, 4, 4);
        panel.add(new JLabel("CEP ->"), gbc);
        gbc.gridx = 4; gbc.gridwidth = 2; gbc.weightx = 1.0; gbc.insets = new Insets(4, 4, 4, 4);
        cepField = new JTextField();
        panel.add(cepField, gbc);

        // Linha 2: Cidade e Estado
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panel.add(new JLabel("City ->"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        cityField = new JTextField();
        panel.add(cityField, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1; gbc.weightx = 0; gbc.insets = new Insets(4, 20, 4, 4);
        panel.add(new JLabel("Estado ->"), gbc);
        gbc.gridx = 4; gbc.gridwidth = 2; gbc.weightx = 1.0; gbc.insets = new Insets(4, 4, 4, 4);
        stateField = new JTextField();
        panel.add(stateField, gbc);

        return panel;
    }

    private JPanel  createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);

        this.cancelButton = new RoundedButton("  Cancelar  ", 30);
        this.saveButton = new RoundedButton("  Finalizar  ", 30);

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        return buttonPanel;
    }

    private JPanel createPersonalInfo(){
        JPanel personalInfo = new JPanel(new GridBagLayout());
        personalInfo.setOpaque(false);

        GridBagConstraints gbc_personalInfo = new GridBagConstraints();
        gbc_personalInfo.insets = new Insets(4, 4, 4, 4);
        gbc_personalInfo.anchor = GridBagConstraints.WEST;
        gbc_personalInfo.fill = GridBagConstraints.HORIZONTAL;

        gbc_personalInfo.gridx = 0;
        gbc_personalInfo.gridy = 0;
        gbc_personalInfo.weightx = 0;
        JLabel nameLabel = new JLabel("Nome -> ");
        personalInfo.add(nameLabel, gbc_personalInfo);

        gbc_personalInfo.gridx = 1;
        gbc_personalInfo.weightx = 1.0;
        nameField = new JTextField(30);
        personalInfo.add(nameField, gbc_personalInfo);

        JLabel dateOfBirthLabel = new JLabel("Nascimento -> ");
        gbc_personalInfo.gridx = 2;
        gbc_personalInfo.weightx = 0;
        gbc_personalInfo.insets = new Insets(4, 20, 4, 4);
        personalInfo.add(dateOfBirthLabel, gbc_personalInfo);

        dateOfBirthField = new JTextField(10);
        gbc_personalInfo.gridx = 3;
        gbc_personalInfo.weightx = 1.0;
        gbc_personalInfo.insets = new Insets(4, 4, 4, 4);
        personalInfo.add(dateOfBirthField, gbc_personalInfo);

        return personalInfo;
    }

    public String getNameFieldValue() {
        return this.nameField.getText();
    }

    public String getDateOfBirthFieldValue() {
        return this.dateOfBirthField.getText();
    }

    public String getStreetFieldValue() {
        return this.streetField.getText();
    }

    public String getNeighborhoodFieldValue() {
        return this.neighborhoodField.getText();
    }

    public String getCityFieldValue() {
        return this.cityField.getText();
    }

    public String getStateFieldValue() {
        return this.stateField.getText();
    }

    public String getCepFieldValue() {
        return this.cepField.getText();
    }
}
