package com.cauandev.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class GeneralController {
    private Map<String, Parent> root = new HashMap<>();
    private Stage stg;

    public GeneralController(Stage stage) {
        Parent INITIAL_ROOT = new InitialViewController();
        this.stg = stage;
        Scene scene = new Scene(INITIAL_ROOT);
        stg.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
