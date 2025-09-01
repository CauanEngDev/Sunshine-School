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
        gbc_avatar.gridheight = 4;
        gbc_avatar.anchor = GridBagConstraints.NORTH;
        gbc_avatar.insets = new Insets(20, 20, 20, 20);
        this.add(avatarLabel, gbc_avatar);

        JPanel formContainer = new JPanel();
        formContainer.setOpaque(false);
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

        formContainer.add(createPersonalInfo());
        formContainer.add(createUniqueFields());
        formContainer.add(createAddressPanel());
        formContainer.add(Box.createVerticalGlue());
        formContainer.add(createButtonPanel());

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 1;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;
        gbcMain.fill = GridBagConstraints.HORIZONTAL;
        gbcMain.anchor = GridBagConstraints.NORTH;
        this.add(formContainer, gbcMain);
    }

    protected abstract JPanel createUniqueFields();

    private JPanel createAddressPanel() {
        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));
        addressPanel.setOpaque(false);

        JPanel topRowPanel = new JPanel(new GridBagLayout());
        topRowPanel.setLayout(new GridLayout(1, 6, 10, 0));
        topRowPanel.setOpaque(false);

        topRowPanel.add(new JLabel("Rua -> "));
        this.streetField = new JTextField(30);
        topRowPanel.add(streetField);

        topRowPanel.add(new JLabel("Bairro -> "));
        this.neighborhoodField = new JTextField(30);
        topRowPanel.add(neighborhoodField);

        topRowPanel.add(new JLabel("CEP -> "));
        this.cepField = new JTextField(8);
        topRowPanel.add(cepField);


        JPanel backRowPanel = new JPanel(new GridBagLayout());
        backRowPanel.setLayout(new GridLayout(1, 4, 10, 0));
        backRowPanel.setOpaque(false);

        backRowPanel.add(new JLabel("City -> "));
        this.cityField = new JTextField(30);
        backRowPanel.add(cityField);

        backRowPanel.add(new JLabel("Estado -> "));
        this.stateField = new JTextField(30);
        backRowPanel.add(stateField);

        addressPanel.add(topRowPanel);
        addressPanel.add(backRowPanel);

        return addressPanel;
    }

    private JPanel  createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        buttonPanel.setOpaque(false);

        this.cancelButton = new RoundedButton("  Cancelar  ", 18);
        this.saveButton = new RoundedButton("  Finalizar  ", 18);

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        return buttonPanel;
    }

    private JPanel createPersonalInfo(){
        JPanel personalInfo = new JPanel(new GridBagLayout());
        personalInfo.setOpaque(false);
        personalInfo.setLayout(new GridLayout());

        GridBagConstraints gbc_personalInfo = new GridBagConstraints();
        gbc_personalInfo.insets = new Insets(5, 5, 5, 5);
        gbc_personalInfo.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Nome -> ");
        gbc_personalInfo.gridx = 0;
        gbc_personalInfo.gridy = 0;
        gbc_personalInfo.weightx = 0;
        personalInfo.add(nameLabel, gbc_personalInfo);

        this.nameField = new JTextField(30);
        gbc_personalInfo.gridx = 1;
        gbc_personalInfo.gridy = 0;
        gbc_personalInfo.weightx = 1.0;
        gbc_personalInfo.fill = GridBagConstraints.HORIZONTAL;
        personalInfo.add(nameField, gbc_personalInfo);

        JLabel dateOfBirthLabel = new JLabel("Nascimento -> ");
        gbc_personalInfo.gridx = 0;
        gbc_personalInfo.gridy = 1;
        gbc_personalInfo.weightx = 0;
        personalInfo.add(dateOfBirthLabel, gbc_personalInfo);

        this.dateOfBirthField = new JTextField(30);
        gbc_personalInfo.gridx = 1;
        gbc_personalInfo.gridy = 1;
        gbc_personalInfo.weightx = 1.0;
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
