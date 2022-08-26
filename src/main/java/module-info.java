module com.onegin.language {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.onegin.language to javafx.fxml;
    opens com.onegin.language.gui to javafx.fxml;
    opens com.onegin.language.gui.components to javafx.fxml;

    exports com.onegin.language;
    exports com.onegin.language.gui;

}