package com.cauandev.controller;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;

public class GeneralController {
    public static Map<String, AnchorPane> root = new HashMap<>();
    public static Scene scene;

    public GeneralController() {
        AnchorPane INITIAL_ROOT = new InitialViewController();
        scene = new Scene(INITIAL_ROOT);
    }

    public Scene getScene() {
        return scene;
    }

    public static void switchView(String viewName, AnchorPane view) {
        root.putIfAbsent(viewName, view);
        scene.setRoot(root.get(viewName));
    }
}
