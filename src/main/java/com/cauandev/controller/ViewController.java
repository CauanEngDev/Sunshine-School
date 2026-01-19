package com.cauandev.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewController {
    private static Scene currentView;
    private static Stage stage;

    public ViewController(Scene initialView, Stage stg) {
        currentView = initialView;
        stage = stg;
        stage.setScene(currentView);
        stage.setResizable(false);
        stage.show();
    }
}
