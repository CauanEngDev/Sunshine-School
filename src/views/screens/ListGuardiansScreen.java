package views.screens;

import models.panels.ImagePanel;
import utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ListGuardiansScreen extends ImagePanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private JLabel avatarLabel;

    public ListGuardiansScreen() {
        super("/resources/Tela Padrão 3.png");
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        avatarLabel = new JLabel();
        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/resources/Emoji_Responsavel_Triste.png"));
        Image resizedAvatar = avatarIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        avatarLabel.setIcon(new ImageIcon(resizedAvatar));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(40, 40, 20, 20);
        this.add(avatarLabel, gbc);

        JLabel titleLabel = new JLabel("Gerenciar Responsáveis", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Magic School One", Font.BOLD, 48));
        titleLabel.setForeground(new Color(139, 69, 19));

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 10, 40);
        this.add(titleLabel, gbc);

        String[] columnNames = {"ID", "Nome", "Telefone", "Nº Dependentes", "Ação"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
        };
        table = new JTable(tableModel);
        configureTableAppearance();

        JScrollPane scrollPane = new JScrollPane(table);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 40);
        this.add(scrollPane, gbc);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        backButton = new RoundedButton("Voltar", 24);
        bottomPanel.add(backButton);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 40);
        this.add(bottomPanel, gbc);
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public void addBackButtonListener(ActionListener listener) { backButton.addActionListener(listener); }
    private void configureTableAppearance() {
        table.setRowHeight(40);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
    }
}