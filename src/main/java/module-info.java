module com.jotracker.jo_tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires de.jensd.fx.glyphs.fontawesome;
    requires com.calendarfx.view;
    requires json.simple;
    requires java.desktop;
    requires javafx.swing;

    opens com.jotracker.jo_tracker to javafx.fxml;
    exports com.jotracker.jo_tracker;
    exports com.jotracker.jo_tracker.Controllers;
    exports com.jotracker.jo_tracker.Models;
    exports com.jotracker.jo_tracker.Views;
}