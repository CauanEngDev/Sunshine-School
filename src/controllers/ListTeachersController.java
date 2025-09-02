package controllers;

import data.SchoolDatabase;
import models.Teacher;
import utils.ButtonColumn;
import views.screens.MainFrame;
import views.screens.ListTeachersScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ListTeachersController {
    private final ListTeachersScreen view;
    private final MainFrame screesPanel;
    private final List<Teacher> teachers;

    public ListTeachersController(MainFrame screesPanel, ListTeachersScreen view) {
        this.view = view;
        this.screesPanel = screesPanel;
        this.teachers = SchoolDatabase.teachers;

        this.view.addBackButtonListener(e -> screesPanel.navigateTo("Teacher_Option_Screen"));

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

        for (Teacher teacher : teachers) {
            tableModel.addRow(new Object[]{
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getQualification(),
                    teacher.getPhone(),
                    deleteIcon
            });
        }
    }

    private void setupTableAction() {
        Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.parseInt(e.getActionCommand());

                int choice = JOptionPane.showConfirmDialog(
                        view, "Tem certeza que deseja excluir o professor '" +
                                teachers.get(modelRow).getName() + "'?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    teachers.remove(modelRow);
                    view.getTableModel().removeRow(modelRow);
                    JOptionPane.showMessageDialog(view, "Professor removido com sucesso!");
                }
            }
        };

        new ButtonColumn(view.getTable(), deleteAction, 4);
    }
}