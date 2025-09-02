package controllers;

import data.SchoolDatabase;
import models.Address;
import models.Guardian;
import views.screens.CreateGuardianScreen;
import views.screens.MainFrame;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GuardianFormController {
    private final CreateGuardianScreen view;
    private final MainFrame screensPanel;

    public  GuardianFormController(CreateGuardianScreen view, MainFrame screensPanel) {
        this.view = view;
        this.screensPanel = screensPanel;

        this.view.addSaveButtonListener(e -> saveGuardian());
        this.view.addCancelButtonListener(e -> cancel());
    }

    private void saveGuardian() {
        try {
            String name = view.getNameFieldValue();
            String dobText = view.getDateOfBirthFieldValue();

            String street = view.getStreetFieldValue();
            String city = view.getCityFieldValue();
            String state = view.getStateFieldValue();
            String neighborhood = view.getNeighborhoodFieldValue();
            String cep = view.getCepFieldValue();

            String phone = view.getPhone();

            if (name.isEmpty() || dobText.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty()
                    || neighborhood.isEmpty() || cep.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Todos os campos são obrigatórios!");
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dobText, formatter);

            Address address = new Address(street, city, state, neighborhood, cep);
            Guardian guardian = new Guardian(name, dateOfBirth, address, 0, phone);


            JOptionPane.showMessageDialog(view, "Responsável salvo com sucesso!");
            SchoolDatabase.guardians.add(guardian);

            screensPanel.navigateTo("Guardian_Option_Screen");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data invalido! Use dd/mm/aaaa.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Ocorreu um erro ao salvar" + ex.getMessage());
        }
    }

    private void cancel() {
        screensPanel.navigateTo("Guardian_Option_Screen");
    }
}
