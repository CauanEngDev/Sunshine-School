package com.cauandev;

import com.cauandev.controller.teacher_views.TeacherCreateView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Preview extends Application {
    @Override
    public void start(Stage stage) {
        TeacherCreateView view = new TeacherCreateView();

        Scene scene = new Scene(view);
        stage.setTitle("Preview: Sunshine School - Professor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
