module SunshineSchool {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;

    opens com.cauandev to  javafx.fxml, javafx.graphics;

    opens assets.fonts to javafx.graphics;
    opens assets.stylesheets to javafx.graphics;
    opens view to javafx.fxml;

    exports com.cauandev;
}