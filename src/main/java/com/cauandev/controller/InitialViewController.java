package com.cauandev.controller;

import com.cauandev.util.FxFunctions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class InitialViewController {
    FxFunctions fxFunctions = new FxFunctions();
    @FXML
    private Button button;

    public InitialViewController() throws Exception {
        Parent root = fxFunctions.ViewLoader("/view/InitialView.fxml");
    }

    public void buttonClicked() {
        
    }
}
