package com.cauandev.controller;

import com.cauandev.util.ViewFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import static com.cauandev.enums.ViewNames.STUDENT_OPTION;
import static com.cauandev.enums.ViewNames.TEACHER_OPTION;
import static java.lang.IO.println;

public class OptionViewController extends AnchorPane {
    @FXML private Button studentButton;
    @FXML private Button guardianButton;
    @FXML private Button teacherButton;
    @FXML private Button classButton;

    public OptionViewController() {
        ViewFunctions.ViewLoader("/view/ChooseView.fxml", this);
    }

    @FXML
    public void initialize() {
        this.studentButton.setOnAction(event -> GeneralController.switchView(STUDENT_OPTION));
        this.guardianButton.setOnAction(event -> println("Imperio!"));
        this.teacherButton.setOnAction(event -> GeneralController.switchView(TEACHER_OPTION));
        this.classButton.setOnAction(event -> println("Estupefaça!"));
    }
}
