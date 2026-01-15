package com.cauandev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SunshineApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/InitialView.fxml"));
        Scene scene = new Scene(root, 960, 540);
        stage.setScene(scene);
        stage.show();
    }

    void main() {
        launch();
    }
}