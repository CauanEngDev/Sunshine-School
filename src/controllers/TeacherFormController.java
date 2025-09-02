package controllers;

import data.SchoolDatabase;
import models.Address;
import models.Teacher;
import views.screens.CreateTeacherScreen;
import views.screens.MainFrame;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TeacherFormController {
    private final CreateTeacherScreen view;
    private final MainFrame screensPanel;

    public  TeacherFormController(CreateTeacherScreen view, MainFrame screensPanel) {
        this.view = view;
        this.screensPanel = screensPanel;

        this.view.addSaveButtonListener(e -> saveTeacher());
        this.view.addCancelButtonListener(e -> cancel());
    }

    private void saveTeacher() {
        try {
            String name = view.getNameFieldValue();
            String dobText = view.getDateOfBirthFieldValue();

            String street = view.getStreetFieldValue();
            String city = view.getCityFieldValue();
            String state = view.getStateFieldValue();
            String neighborhood = view.getNeighborhoodFieldValue();
            String cep = view.getCepFieldValue();

            String phone = view.getPhone();
            String qualification = view.getQualification();

            if (name.isEmpty() || dobText.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty()
                    || neighborhood.isEmpty() || cep.isEmpty() || phone.isEmpty() || qualification == null) {
                JOptionPane.showMessageDialog(view, "Todos os campos são obrigatórios!");
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dobText, formatter);

            Address address = new Address(street, city, state, neighborhood, cep);
            Teacher teacher = new Teacher(name, dateOfBirth, address, 0, qualification, phone);


            JOptionPane.showMessageDialog(view, "Professor salvo com sucesso!");
            SchoolDatabase.teachers.add(teacher);

            screensPanel.navigateTo("Teacher_Option_Screen");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data invalido! Use dd/mm/aaaa.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Ocorreu um erro ao salvar" + ex.getMessage());
        }
    }

    private void cancel() {
        screensPanel.navigateTo("Teacher_Option_Screen");
    }
}
