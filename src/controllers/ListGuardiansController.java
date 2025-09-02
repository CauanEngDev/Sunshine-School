package controllers;

import data.SchoolDatabase;
import models.Guardian;
import utils.ButtonColumn;
import views.screens.MainFrame;
import views.screens.ListGuardiansScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ListGuardiansController {
    private final ListGuardiansScreen view;
    private final MainFrame screesPanel;
    private final List<Guardian> guardians;

    public ListGuardiansController(MainFrame screesPanel, ListGuardiansScreen view) {
        this.view = view;
        this.screesPanel = screesPanel;
        this.guardians = SchoolDatabase.guardians;

        this.view.addBackButtonListener(e -> screesPanel.navigateTo("Guardian_Option_Screen"));

        setupTableAction();
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);

        Icon deleteIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/resources/Emoji_Lixeira.png"))
                        .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)
        );

        for (Guardian guardian : guardians) {
            tableModel.addRow(new Object[]{
                    guardian.getId(),
                    guardian.getName(),
                    guardian.getPhone(),
                    guardian.getDependents().size(),
                    deleteIcon
            });
        }
    }

    private void setupTableAction() {
        Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.parseInt(e.getActionCommand());

                int choice = JOptionPane.showConfirmDialog(
                        view, "Tem certeza que deseja excluir o responsável '" +
                                guardians.get(modelRow).getName() + "'?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    guardians.remove(modelRow);
                    view.getTableModel().removeRow(modelRow);
                    JOptionPane.showMessageDialog(view, "Responsável removido com sucesso!");
                }
            }
        };

        new ButtonColumn(view.getTable(), deleteAction, 4);
    }
}