package models.panels;

import utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public abstract class BaseViewPanel extends ImagePanel {
    protected JLabel nameValueLabel;
    protected JLabel dateOfBirthValueLabel;
    protected JLabel streetValueLabel;
    protected JLabel cityValueLabel;
    protected JLabel cepValueLabel;
    protected JLabel neighborhoodValueLabel;
    protected JLabel stateValueLabel;
    protected JButton backButton;
    protected final JLabel avatarLabel;

    public BaseViewPanel() {
        super("/resources/Tela Padrão 2.png");
        this.setLayout(new GridBagLayout());

        avatarLabel = new JLabel();
        GridBagConstraints gbcAvatar = new GridBagConstraints();
        gbcAvatar.gridx = 0;
        gbcAvatar.gridy = 0;
        gbcAvatar.anchor = GridBagConstraints.NORTH;
        gbcAvatar.insets = new Insets(40, 40, 20, 20);
        this.add(avatarLabel, gbcAvatar);

        JPanel formContainer = new JPanel();
        formContainer.setOpaque(false);
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

        formContainer.add(createPersonalInfoPanel());
        formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        formContainer.add(createUniqueFieldsPanel());
        formContainer.add(Box.createRigidArea(new Dimension(0, 40)));
        formContainer.add(createAddressPanel());
        formContainer.add(Box.createVerticalGlue());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        backButton = new RoundedButton("Voltar", 30);
        buttonPanel.add(backButton);
        formContainer.add(buttonPanel);

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 1;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;
        gbcMain.anchor = GridBagConstraints.NORTH;
        gbcMain.fill = GridBagConstraints.HORIZONTAL;
        gbcMain.insets = new Insets(20, 0, 20, 40);
        this.add(formContainer, gbcMain);
    }

    protected abstract JPanel createUniqueFieldsPanel();

    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("Nome ->"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        nameValueLabel = new JLabel();
        panel.add(nameValueLabel, gbc);

        gbc.gridx = 2; gbc.weightx = 0; gbc.insets = new Insets(4, 20, 4, 4);
        panel.add(new JLabel("Nascimento ->"), gbc);
        gbc.gridx = 3; gbc.weightx = 1.0; gbc.insets = new Insets(4, 4, 4, 4);
        dateOfBirthValueLabel = new JLabel();
        panel.add(dateOfBirthValueLabel, gbc);

        return panel;
    }

    private JPanel createAddressPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("Rua ->"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 5; gbc.weightx = 1.0;
        streetValueLabel = new JLabel();
        panel.add(streetValueLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panel.add(new JLabel("Bairro ->"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        neighborhoodValueLabel = new JLabel();
        panel.add(neighborhoodValueLabel, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1; gbc.weightx = 0; gbc.insets = new Insets(4, 20, 4, 4);
        panel.add(new JLabel("CEP ->"), gbc);
        gbc.gridx = 4; gbc.gridwidth = 2; gbc.weightx = 1.0; gbc.insets = new Insets(4, 4, 4, 4);
        cepValueLabel = new JLabel();
        panel.add(cepValueLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panel.add(new JLabel("Cidade ->"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        cityValueLabel = new JLabel();
        panel.add(cityValueLabel, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1; gbc.weightx = 0; gbc.insets = new Insets(4, 20, 4, 4);
        panel.add(new JLabel("Estado ->"), gbc);
        gbc.gridx = 4; gbc.gridwidth = 2; gbc.weightx = 1.0; gbc.insets = new Insets(4, 4, 4, 4);
        stateValueLabel = new JLabel();
        panel.add(stateValueLabel, gbc);

        return panel;
    }
}