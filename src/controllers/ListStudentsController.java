package controllers;

import data.SchoolDatabase;
import models.Student;
import utils.ButtonColumn;
import views.screens.MainFrame;
import views.screens.ListStudentScreen;
import views.screens.StudentDetailsScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ListStudentsController {
    private final ListStudentScreen view;
    private final MainFrame screensPanel;
    private final List<Student> students;

    public ListStudentsController(MainFrame screensPanel, ListStudentScreen view) {
        this.view = view;
        this.screensPanel = screensPanel;
        this.students = SchoolDatabase.students;

        this.view.addBackButtonListener(e -> screensPanel.navigateTo("Student_Option_Screen"));

        setupTableActions();
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);

        Icon deleteIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/resources/Emoji_Lixeira.png"))
                        .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)
        );

        for (Student student : students) {
            tableModel.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    deleteIcon
            });
        }
    }

    private void setupTableActions() {
        Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.parseInt(e.getActionCommand());
                deleteStudent(modelRow);
            }
        };
        new ButtonColumn(view.getTable(), deleteAction, 2);

        view.getTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());

                if (e.getClickCount() == 1 && column != 2) {
                    viewStudentDetails(row);
                }
            }
        });
    }

    private void deleteStudent(int modelRow) {
        int choice = JOptionPane.showConfirmDialog(
                view, "Tem certeza que deseja excluir o aluno '" +
                        students.get(modelRow).getName() + "'?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            students.remove(modelRow);
            view.getTableModel().removeRow(modelRow);
            JOptionPane.showMessageDialog(view, "Aluno removido com sucesso!");
        }
    }

    private void viewStudentDetails(int row) {
        if (row < 0 || row >= students.size()) return;
        Student selectedStudent = students.get(row);

        StudentDetailsScreen detailsScreen = new StudentDetailsScreen(selectedStudent);
        new StudentDetailsController(screensPanel, detailsScreen);

        String screenName = "Student_Detail_Screen" + selectedStudent.getId();
        screensPanel.addScreen(detailsScreen, screenName);
        screensPanel.navigateTo(screenName);
    }
}