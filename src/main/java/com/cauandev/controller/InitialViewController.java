package com.cauandev.controller;

import com.cauandev.enums.ViewNames;
import com.cauandev.util.ViewFunctions;

import module javafx.controls;
import javafx.fxml.FXML;

public class InitialViewController extends AnchorPane {
    @FXML private Button initButton;

    public InitialViewController() {
        ViewFunctions.ViewLoader("/view/InitialView.fxml", this);
    }

    @FXML
    public void initialize() {
        this.initButton.setOnAction(event -> handleGif());
    }

    public void handleGif(){
        VBox parent = (VBox) initButton.getParent();
        parent.setLayoutX(390);
        parent.setLayoutY(320);

        initButton.setVisible(false);
        initButton.setManaged(false);

        ImageView loadingGif = new ImageView(ViewFunctions.loadImage("/assets/images/loading.gif"));
        loadingGif.setPreserveRatio(true);
        loadingGif.setSmooth(true);

        int index = parent.getChildren().indexOf(initButton);
        parent.getChildren().set(index, loadingGif);

        PauseTransition pause = new PauseTransition(Duration.seconds(7));
        pause.setOnFinished(event -> GeneralController.switchView(ViewNames.OPTION));

        pause.play();
    }
}
