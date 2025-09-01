package models.screenmodels;

import utils.RoundedButton;
import models.panels.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class OptionScreen extends ImagePanel {
    protected RoundedButton createButton;
    protected RoundedButton editButton;
    protected RoundedButton removeButton;
    protected RoundedButton searchButton;
    private JButton backButton;

    public OptionScreen(String title, String imagePath) {
        super("/resources/Tela Padrão 1.png");

        this.setLayout(new GridBagLayout());

        ImageIcon backIconOriginal = new ImageIcon(getClass().getResource("/resources/Símbolo_Voltar.png"));
        Image resizedBackImage = backIconOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        backButton = new JButton(new ImageIcon(resizedBackImage));

        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setOpaque(false);

        GridBagConstraints gbcBack = new GridBagConstraints();
        gbcBack.gridx = 0;
        gbcBack.gridy = 0;
        gbcBack.anchor = GridBagConstraints.NORTHWEST;
        gbcBack.insets = new Insets(10, 10, 0, 0);
        this.add(backButton, gbcBack);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        JPanel optionPanel = new JPanel();
        optionPanel.setOpaque(false);
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));

        int imageWidth = 300,  imageHeight = 300;

        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));
        Image resizedImage =  originalIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(resizedImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        RoundedButton optionBox = new RoundedButton(title, 40);
        optionBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        optionPanel.add(imageLabel);
        optionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        optionPanel.add(optionBox);

        centerPanel.add(optionPanel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setOpaque(false);

        createButton = new  RoundedButton("Criar", 30);
        removeButton = new RoundedButton("Remover", 30);
        searchButton = new RoundedButton("Buscar", 30);
        editButton = new RoundedButton("Atualizar", 30);

        buttonPanel.add(createButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(editButton);

        gbc.gridy = 1;
        centerPanel.add(buttonPanel, gbc);

        JPanel pusherPanel = new JPanel();
        pusherPanel.setOpaque(false);

        gbc.gridy = 2;
        gbc.weighty = 1.0;
        centerPanel.add(pusherPanel, gbc);

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;
        gbcMain.weighty = 1.0;
        this.add(centerPanel, gbcMain);
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addRemoveButtonListener(ActionListener listener) {
        removeButton.addActionListener(listener);
    }

    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }
}
