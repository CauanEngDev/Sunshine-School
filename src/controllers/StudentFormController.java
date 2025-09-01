package controllers;

import models.Address;
import models.Guardian;
import models.Student;
import views.screens.CreateStudentScreen;
import views.screens.MainFrame;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StudentFormController {
    private final CreateStudentScreen view;
    private final MainFrame screensPanel;

    public  StudentFormController(CreateStudentScreen view, MainFrame screensPanel) {
        this.view = view;
        this.screensPanel = screensPanel;

        this.view.addSaveButtonListener(e -> saveStudent());
        this.view.addCancelButtonListener(e -> cancel());
    }

    private void saveStudent() {
        try {
            String name = view.getNameFieldValue();
            String dobText = view.getDateOfBirthFieldValue();

            String street = view.getStreetFieldValue();
            String city = view.getCityFieldValue();
            String state = view.getStateFieldValue();
            String neighborhood = view.getNeighborhoodFieldValue();
            String cep = view.getCepFieldValue();

            String birthPlace = view.getBirth();
            Guardian guardian = view.getSelectedGuardian();

            if (name.isEmpty() || dobText.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty()
                    || neighborhood.isEmpty() || cep.isEmpty() || birthPlace.isEmpty() || guardian == null) {
                JOptionPane.showMessageDialog(view, "Todos os campos são obrigatórios!");
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dobText, formatter);

            Address adddress = new Address(street, city, state, neighborhood, cep);
            Student student = new Student(name, dateOfBirth, adddress, 0, birthPlace, guardian);

            JOptionPane.showMessageDialog(view, "Aluno salvo com sucesso!");

            screensPanel.navigateTo("Student_Option_Screen");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data invalido! Use dd/mm/aaaa.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Ocorreu um erro ao salvar" + ex.getMessage());
        }
    }

    private void cancel() {
        screensPanel.navigateTo("Student_Option_Screen");
    }
}
