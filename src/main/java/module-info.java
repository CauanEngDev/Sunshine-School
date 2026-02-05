module SunshineSchool {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires ch.qos.logback.classic;
    requires org.slf4j;
    requires org.jetbrains.annotations;
    requires SunshineSchool;

    opens com.cauandev to  javafx.fxml, javafx.graphics;
    opens com.cauandev.controller to javafx.fxml;

    opens assets.fonts to javafx.graphics;
    opens assets.stylesheets to javafx.graphics;
    opens view to javafx.fxml;

    exports com.cauandev;
}