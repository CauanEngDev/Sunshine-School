package com.cauandev.controller;

import com.cauandev.enums.ViewNames;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;

public class GeneralController {
    public static Map<ViewNames, AnchorPane> root = new HashMap<>();
    public static Scene scene;

    public GeneralController() {
        AnchorPane INITIAL_ROOT = new InitialViewController();
        scene = new Scene(INITIAL_ROOT);
    }

    public Scene getScene() {
        return scene;
    }

    public static void switchView(ViewNames viewName) {
        AnchorPane view = root.get(viewName);

        if (view == null) {
            view = createView(viewName);
            root.put(viewName, view);
        }

        scene.setRoot(view);
    }

    private static AnchorPane createView(ViewNames viewName) {
        return switch (viewName) {
            case OPTION -> new OptionViewController();
            case STUDENT_OPTION -> new StudentViewController();
            case TEACHER_OPTION -> new TeacherViewController();
            default -> throw new IllegalArgumentException("Erro ao tentar criar tela " + viewName);
        };
    }
}
