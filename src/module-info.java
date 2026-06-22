module gallerees {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports gallerees.main;
    exports gallerees.model;
    exports gallerees.controller;

    opens gallerees.controller to javafx.fxml, javafx.base;
    opens gallerees.model to javafx.fxml, javafx.base;
}
