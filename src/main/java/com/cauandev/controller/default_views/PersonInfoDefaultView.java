package com.cauandev.controller.default_views;

import com.cauandev.util.ViewFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public abstract class PersonInfoDefaultView extends AnchorPane {
    @FXML protected ImageView avatar; // ImageView da imagem de cada view
    @FXML protected TextField nameTextField; // Campo de nome
    @FXML protected TextField birthTextField; // Campo de aniversário
    // Label e TextField limpos, pois em alunos é naturalidade enquanto no professor e guardião é telefone
    @FXML protected Label specificLabel;
    @FXML protected TextField specificTextField;
    // HBox vazio, pois alunos tem campo dependência, enquanto professor tem formação
    @FXML protected HBox containerExtra;

    // TextFields de endereço
    @FXML protected TextField streetTextField;
    @FXML protected TextField neighbourhoodTextField;
    @FXML protected TextField postalCodeTextField;
    @FXML protected TextField cityTextField;
    @FXML protected TextField stateTextField;

    // Botões
    @FXML protected Button cancelButton;
    @FXML protected Button confirmButton;


    public PersonInfoDefaultView() { ViewFunctions.ViewLoader("/view/PersonCreateView.fxml", this); }

    public void setAvatar(String avatarURL) { this.avatar.setImage(ViewFunctions.loadImage(avatarURL)); }

    public void setSpecificLabel(String message) { this.specificLabel.setText(message); }

    @FXML
    public void initialize() {
        confirmButton.setOnAction(event -> confirmAction());
    }
    protected abstract void confirmAction();
}
