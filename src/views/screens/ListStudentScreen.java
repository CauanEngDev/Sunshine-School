package views.screens;

import models.panels.ImagePanel;
import utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ListStudentScreen extends ImagePanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private JLabel avatarLabel;

    public ListStudentScreen() {
        super("/resources/Tela Padrão 3.png");
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        avatarLabel = new JLabel();
        ImageIcon wizardIcon = new ImageIcon(getClass().getResource("/resources/Emoji_Aluno_Triste.png"));
        Image resizedWizard = wizardIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        avatarLabel.setIcon(new ImageIcon(resizedWizard));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(40, 40, 20, 20);
        this.add(avatarLabel, gbc);


        JLabel titleLabel = new JLabel("Gerenciar Alunos", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Magic School One", Font.BOLD, 48));
        titleLabel.setForeground(new Color(139, 69, 19));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 10, 40);
        this.add(titleLabel, gbc);

        String[] columnNames = {"ID", "Nome do Aluno", "Ação"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };
        table = new JTable(tableModel);
        configureTableAppearance();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 40);
        this.add(scrollPane, gbc);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        backButton = new RoundedButton("Voltar", 30);
        bottomPanel.add(backButton);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(10, 0, 20, 40);
        this.add(bottomPanel, gbc);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addBackButtonListener(ActionListener listener) {
        this.backButton.addActionListener(listener);
    }

    private void configureTableAppearance() {
        table.setRowHeight(40);
        table.setFont(new Font("Magic School One", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Magic School One", Font.BOLD, 18));
    }
}