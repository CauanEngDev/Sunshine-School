package com.cauandev.controller;

import com.cauandev.util.FxFunctions;

import module javafx.controls;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.IO.println;

public class InitialViewController extends AnchorPane {
    private static final Logger logger = LoggerFactory.getLogger(InitialViewController.class);
    @FXML private Button initButton;

    public InitialViewController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InitialView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (Exception e) {
            logger.error("Erro ao tentar carregar tela inicial", e);
        }
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

        ImageView loadingGif = new ImageView(FxFunctions.loadImage("/assets/images/loading.gif"));
        loadingGif.setPreserveRatio(true);
        loadingGif.setSmooth(true);

        int index = parent.getChildren().indexOf(initButton);
        parent.getChildren().set(index, loadingGif);

        PauseTransition pause = new PauseTransition(Duration.seconds(8));
        pause.setOnFinished(event -> println("Crucius!"));

        pause.play();
    }
}
