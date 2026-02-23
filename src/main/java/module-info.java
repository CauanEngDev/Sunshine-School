module SunshineSchool {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires ch.qos.logback.classic;
    requires org.slf4j;
    requires org.jetbrains.annotations;

    opens com.cauandev to  javafx.fxml, javafx.graphics;
    opens com.cauandev.controller to javafx.fxml;

    opens assets.fonts to javafx.graphics;
    opens assets.stylesheets to javafx.graphics;
    opens view to javafx.fxml;
    opens assets.images to javafx.graphics, javafx.fxml;

    exports com.cauandev;
    exports com.cauandev.database;
    exports com.cauandev.service;
    exports com.cauandev.enums;
    exports com.cauandev.model;
    exports com.cauandev.controller.teacher_views;
    opens com.cauandev.database to javafx.fxml, javafx.graphics;
    opens com.cauandev.controller.student_views to javafx.fxml;
    opens com.cauandev.controller.default_views to javafx.fxml;
    opens com.cauandev.controller.teacher_views to javafx.fxml, org.testfx.junit5, org.testfx.core;
}