module secondlibrary.secondlibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires java.base;
    requires java.logging;
    requires org.json;

    opens secondlibrary.main to javafx.fxml;
    exports secondlibrary.main;
    exports secondlibrary.controller;
    opens secondlibrary.controller to javafx.fxml;
}