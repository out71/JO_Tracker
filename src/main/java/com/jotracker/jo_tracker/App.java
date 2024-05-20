package com.jotracker.jo_tracker;

import com.jotracker.jo_tracker.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showClientWindow();
    }
}
