package com.cauandev.controller;

import com.cauandev.util.ViewFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.IO.println;

public class OptionViewController extends AnchorPane {
    private static final Logger logger = LoggerFactory.getLogger(OptionViewController.class);

    @FXML private Button studentButton;
    @FXML private Button guardianButton;
    @FXML private Button teacherButton;
    @FXML private Button classButton;

    public OptionViewController() {
        ViewFunctions.ViewLoader("/view/ChooseView.fxml", this);
    }

    @FXML
    public void initialize() {
        this.studentButton.setOnAction(event -> println("Avada Kedavra!"));
        this.guardianButton.setOnAction(event -> println("Crucio!"));
        this.teacherButton.setOnAction(event -> println("Imperio!"));
        this.classButton.setOnAction(event -> println("Estupefaça!"));
    }
}
