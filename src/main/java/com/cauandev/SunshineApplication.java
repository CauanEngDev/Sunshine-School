package com.cauandev;

import com.cauandev.controller.GeneralController;
import javafx.application.Application;
import javafx.stage.Stage;

public class SunshineApplication extends Application {
    @Override
    public void start(Stage stage) {
        GeneralController generalController = new GeneralController();
        stage.setScene(generalController.getScene());
        stage.setResizable(false);
        stage.show();
    }

    void main() {
        launch();
    }
}